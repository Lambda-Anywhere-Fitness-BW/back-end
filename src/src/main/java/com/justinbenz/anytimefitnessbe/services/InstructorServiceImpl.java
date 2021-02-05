package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.exceptions.ResourceNotFoundException;
import com.justinbenz.anytimefitnessbe.models.*;
import com.justinbenz.anytimefitnessbe.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("instructorService")
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository instructrepos;

    @Autowired
    private FitnessClassRepository fcrepos;

    @Autowired
    private FitnessClassTypeRepository fctyperepos;

    @Autowired
    private ClientRepository clientrepos;

    @Autowired
    private UserRepository userrepos;


    @Transactional
    @Override
    public Instructor save(Instructor instructor) {
        Instructor newTeach = new Instructor();

        if(instructor.getInstructorid() != 0){
            instructrepos.findById(instructor.getInstructorid())
                    .orElseThrow(() -> new ResourceNotFoundException("Instructorid " + instructor.getInstructorid() + " not found!"));
            newTeach.setInstructorid(instructor.getInstructorid());
        }

        newTeach.setSpecialty(instructor.getSpecialty());
        newTeach.setCredentials(instructor.getCredentials());
        newTeach.setYearsexp(instructor.getYearsexp());

        User user = userrepos.findById(instructor.getUser().getUserid()).orElseThrow(() -> new ResourceNotFoundException("User with id" + instructor.getUser().getUserid() + " not found!"));
        newTeach.setUser(user);

        if(instructor.getFitnessClasses().size() > 0) {
            for (FitnessClass fc : instructor.getFitnessClasses()) {
                FitnessClass fitnessClass = new FitnessClass();

                fitnessClass.setLocation(fc.getLocation());
                fitnessClass.setName(fc.getName());
                fitnessClass.setDuration(fc.getDuration());
                fitnessClass.setStarttime(fc.getStarttime());
                fitnessClass.setIntensitylevel(fc.getIntensitylevel());

                fitnessClass.setInstructor(newTeach);
                fitnessClass.setFitnessclasstype(fctyperepos.findById(fc.getFitnessclasstype().getFitnessclasstypeid())
                        .orElseThrow(() -> new ResourceNotFoundException("Class type with id:" + fc.getFitnessclasstype().getFitnessclasstypeid() + "was not found!")));

                for (ClientFitnessClass c : fc.getClients()) {
                    ClientFitnessClass cfc = new ClientFitnessClass();
                    cfc.setClient(clientrepos.findById(c.getClient().getClientid())
                            .orElseThrow(() -> new ResourceNotFoundException("Client with id:" + c.getClient().getClientid() + "was not found!")));
                    cfc.setFitnessclass(fitnessClass);
                    fitnessClass.getClients().add(cfc);
                }

                newTeach.getFitnessClasses().add(fitnessClass);
            }
        }

        System.out.println(newTeach.getFitnessClasses().size());
        return instructrepos.save(newTeach);
    }

    @Override
    public Instructor update(Instructor instructor, long id) {
        Instructor currentTeach = findInstructorById(id);

        if(instructor.getSpecialty() != null){
            currentTeach.setSpecialty(instructor.getSpecialty());
        }

        if(instructor.getYearsexp() != 0){
            currentTeach.setYearsexp(instructor.getYearsexp());
        }

        if(instructor.getCredentials() != null){
            currentTeach.setCredentials(instructor.getCredentials());
        }

        if(instructor.getUser() != null) {
            User user = userrepos.findById(instructor.getUser().getUserid()).orElseThrow(() -> new ResourceNotFoundException("User with id" + instructor.getUser().getUserid() + " not found!"));
            currentTeach.setUser(user);
        }

        if(instructor.getFitnessClasses().size() > 0){
            for(FitnessClass fc: instructor.getFitnessClasses()){
                FitnessClass fitnessClass = new FitnessClass();

                fitnessClass.setLocation(fc.getLocation());
                fitnessClass.setName(fc.getName());
                fitnessClass.setDuration(fc.getDuration());
                fitnessClass.setStarttime(fc.getStarttime());
                fitnessClass.setIntensitylevel(fc.getIntensitylevel());

                fitnessClass.setInstructor(currentTeach);
                fitnessClass.setFitnessclasstype(fctyperepos.findById(fc.getFitnessclasstype().getFitnessclasstypeid())
                        .orElseThrow(() -> new ResourceNotFoundException("Class type with id:" + fc.getFitnessclasstype().getFitnessclasstypeid() + "was not found!")));

                for(ClientFitnessClass c: fc.getClients()) {
                    ClientFitnessClass cfc = new ClientFitnessClass();
                    cfc.setClient(clientrepos.findById(c.getClient().getClientid())
                            .orElseThrow(() -> new ResourceNotFoundException("Client with id:" + c.getClient().getClientid() + "was not found!")));
                    cfc.setFitnessclass(fitnessClass);
                    fitnessClass.getClients().add(cfc);
                }

                currentTeach.getFitnessClasses().add(fitnessClass);
            }
        }

        return instructrepos.save(currentTeach);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        instructrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor with id:" + id + " not found!"));
        instructrepos.deleteById(id);
    }

    @Override
    public List<Instructor> findAll() {

        List<Instructor> instructors =  new ArrayList<>();
        instructrepos.findAll().iterator().forEachRemaining(instructors::add);

        return instructors;
    }

    @Override
    public Instructor findInstructorById(long instructorid) {

       return instructrepos.findById(instructorid).orElseThrow(() -> new ResourceNotFoundException("Instructor"));
    }
}
