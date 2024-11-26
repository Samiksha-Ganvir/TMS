//package com.sprint.demo.serviceimpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.sprint.demo.entity.Attachment;
//import com.sprint.demo.repository.AttachmentRepository;
//import com.sprint.demo.service.AttachmentService;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AttachmentServiceImpl implements AttachmentService {
//
//    @Autowired
//    private AttachmentRepository attachmentRepository;
//
//    @Override
//    public List<Attachment> getAllAttachments() {
//        return attachmentRepository.findAll();
//    }
//
//    @Override
//    public Attachment getAttachmentById(Integer id) {
//        Optional<Attachment> attachment = attachmentRepository.findById(id);
//        return attachment.orElseThrow(() -> new RuntimeException("Attachment not found with ID: " + id));
//    }
//
//    @Override
//    public Attachment saveAttachment(Attachment attachment) {
//        return attachmentRepository.save(attachment);
//    }
//
//    @Override
//    public void deleteAttachment(Integer id) {
//        if (!attachmentRepository.existsById(id)) {
//            throw new RuntimeException("Attachment not found with ID: " + id);
//        }
//        attachmentRepository.deleteById(id);
//    }
//}
//
//
//
