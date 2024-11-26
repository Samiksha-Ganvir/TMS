//package com.sprint.demo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.sprint.demo.entity.Attachment;
//import com.sprint.demo.service.AttachmentService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/attachments")
//public class AttachmentController {
//
//    @Autowired
//    private AttachmentService attachmentService;
//
//    @GetMapping
//    public ResponseEntity<List<Attachment>> getAllAttachments() {
//        return new ResponseEntity<>(attachmentService.getAllAttachments(), HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Attachment> getAttachmentById(@PathVariable Integer id) {
//        return new ResponseEntity<>(attachmentService.getAttachmentById(id), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Attachment> createAttachment(@RequestBody Attachment attachment) {
//        return new ResponseEntity<>(attachmentService.saveAttachment(attachment), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAttachment(@PathVariable Integer id) {
//        attachmentService.deleteAttachment(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
