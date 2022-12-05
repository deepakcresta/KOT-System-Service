/*************************************************************************
 * 
 * AADIM INNOVATION CONFIDENTIAL __________________ _ _ _____ _ _ /\ | (_) |_ _| | | (_) / \ __ _
 * __| |_ _ __ ___ | | _ __ _ __ _____ ____ _| |_ _ ___ _ __ / /\ \ / _` |/ _` | | '_ ` _ \ | | | '_
 * \| '_ \ / _ \ \ / / _` | __| |/ _ \| '_ \ / ____ \ (_| | (_| | | | | | | | _| |_| | | | | | | (_)
 * \ V / (_| | |_| | (_) | | | | /_/ \_\__,_|\__,_|_|_| |_| |_| |_____|_| |_|_| |_|\___/ \_/
 * \__,_|\__|_|\___/|_| |_|
 *
 * 
 * All Rights Reserved.
 * 
 * NOTICE: All information contained here in is, and remains the property of Aadim Innovation and
 * its suppliers, if any. The intellectual and technical concepts contained here in are proprietary
 * to Aadim Innovation. Dissemination of this information or reproduction of this material is
 * strictly forbidden unless prior written permission is obtained from Aadim Innovation.
 * 
 */
package com.kotservice.contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactService {

  @Autowired
  public ContactRepository contactRepository;

  public ContactResponseDto addContact(ContactCreateDto contactCreateDto) {
    Contact contact = new Contact();

    contact.setName(contactCreateDto.getName());
    contact.setPhoneNumber(contactCreateDto.getPhoneNumber());
    contact.setEmail(contactCreateDto.getEmail());
    contact.setMessage(contactCreateDto.getMessage());

    Contact savedContact = contactRepository.save(contact);
    ContactResponseDto response = new ContactResponseDto();
    response.setEmail(savedContact.getEmail());
    response.setName(savedContact.getName());
    response.setPhoneNumber(savedContact.getPhoneNumber());
    return response;
    
  
  }

  public ContactResponseDto getContactResponseDto(Contact savedContact) {
    ContactResponseDto response = new ContactResponseDto();
    if (savedContact != null) {
      response.setId(savedContact.getId());
      response.setName(savedContact.getName());
      response.setEmail(savedContact.getEmail());
      response.setPhoneNumber(savedContact.getPhoneNumber());
      response.setMessage(savedContact.getMessage());
    }
    return response;
  }

  public ContactReponseListDto getAll() {
    List<ContactResponseDto> contactResponseList = new ArrayList<>();
    List<Contact> contact = (List<Contact>) contactRepository.findAll();

    for (Contact contacts : contact) {
      contactResponseList.add(getContactResponseDto(contacts));
    }
    ContactReponseListDto response = new ContactReponseListDto();
    response.setContacts(contactResponseList);
    response.setTotal((long) contact.size());

    return response;
  }
  

  public ContactResponseDto getById(Long id) {
    Optional<Contact> optionalContact = contactRepository.findById(id);
    if (optionalContact.isPresent()) {
      return getContactResponseDto(optionalContact.get());
    }
    return null;
  }

  @Transactional
  public void deleteContact(Long id) {
    contactRepository.deleteById(id);
  }

}
