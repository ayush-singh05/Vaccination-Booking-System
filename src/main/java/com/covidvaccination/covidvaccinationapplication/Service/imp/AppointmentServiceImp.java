package com.covidvaccination.covidvaccinationapplication.Service.imp;

import com.covidvaccination.covidvaccinationapplication.DTO.RequestDTO.AppointmentBookingDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.BookingResponseDTO;
import com.covidvaccination.covidvaccinationapplication.DTO.ResponseDTO.CenterResponseDTO;
import com.covidvaccination.covidvaccinationapplication.Exception.DoctorNotFoundException;
import com.covidvaccination.covidvaccinationapplication.Exception.PersonNotFoundException;
import com.covidvaccination.covidvaccinationapplication.Model.Appointment;
import com.covidvaccination.covidvaccinationapplication.Model.Doctor;
import com.covidvaccination.covidvaccinationapplication.Model.Person;
import com.covidvaccination.covidvaccinationapplication.Model.VaccinationCenter;
import com.covidvaccination.covidvaccinationapplication.Repository.AppointmentRepository;
import com.covidvaccination.covidvaccinationapplication.Repository.DoctorRepository;
import com.covidvaccination.covidvaccinationapplication.Repository.PersonRepository;
import com.covidvaccination.covidvaccinationapplication.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentServiceImp implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Override
    public BookingResponseDTO bookAppointment(AppointmentBookingDTO appointmentBookingDTO) throws PersonNotFoundException, DoctorNotFoundException {
        Optional<Person> optionalPerson = personRepository.findById(appointmentBookingDTO.getPersonId());
        if(optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Person Not Exists");
        }
        Optional<Doctor> optionalDoctor = doctorRepository.findById(appointmentBookingDTO.getDoctorId());
        if(optionalDoctor.isEmpty() ) {
            throw new DoctorNotFoundException("Doctor Not Exists");
        }
        Person person = optionalPerson.get();
        Doctor doctor = optionalDoctor.get();

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setDoctor(doctor);
        appointment.setPerson(person);
        Appointment saveAppointment = appointmentRepository.save(appointment);

        doctor.getAppointmentList().add(saveAppointment);
        person.getAppointmentList().add(saveAppointment);

        Doctor savedDoctor = doctorRepository.save(doctor);
        Person savedPerson = personRepository.save(person);
        VaccinationCenter center = savedDoctor.getCenter();

        String text = "Congrats!! "+savedPerson.getName()+" Your appointment has been booked with Doctor "+
                savedDoctor.getName() + ". Your vaccination center name is: " + center.getCenterName() + " Please reach at this address "+
                center.getAddress() + " at this time: " + saveAppointment.getAppointmentDate()+" Dhanyawad!!!";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("akashsingh2442@gmail.com");

        simpleMailMessage.setTo(savedPerson.getEmail());
        simpleMailMessage.setSubject("Congrats!! Appointment Done!!");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);
        CenterResponseDTO centerResponseDTO = new CenterResponseDTO();
        centerResponseDTO.setCenterName(center.getCenterName());
        centerResponseDTO.setAddress(center.getAddress());
        centerResponseDTO.setCenterType(center.getCenterType());

        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        bookingResponseDTO.setPersonName(savedPerson.getName());
        bookingResponseDTO.setDoctorName(savedDoctor.getName());
        bookingResponseDTO.setAppointmentId(saveAppointment.getAppointmentId());
        bookingResponseDTO.setAppointmentDate(saveAppointment.getAppointmentDate());
        bookingResponseDTO.setCenterResponseDTO(centerResponseDTO);

        return bookingResponseDTO;
    }
}
