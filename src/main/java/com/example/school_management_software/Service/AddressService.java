package com.example.school_management_software.Service;

import com.example.school_management_software.Api.ApiException;
import com.example.school_management_software.DTO.AddressDTO;
import com.example.school_management_software.Model.Address;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Repository.AddressRepository;
import com.example.school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    //get
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    //Add
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    //update
    public void updateAddress(AddressDTO addressDTO){
        Address oldAddress = addressRepository.findAddressById(addressDTO.getTeacher_id());

        if(oldAddress == null){
            throw new ApiException("Not found");
        }
        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(oldAddress);
    }

    //delete
    public void deleteAddress(Integer id){
        Address delAddress = addressRepository.findAddressById(id);
        if(delAddress == null){
            throw new ApiException("Not found");
        }
        addressRepository.delete(delAddress);
    }
}
