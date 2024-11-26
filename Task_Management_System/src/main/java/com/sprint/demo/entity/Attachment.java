////package com.sprint.demo.entity;
////
////import jakarta.persistence.*;
////
////@Entity
////@Table(name = "Attachment")
////public class Attachment {
////
////    @Id
////   // @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @Column(name = "AttachmentID")
////    private Integer attachmentId;
////
////    @Column(name = "FileName", nullable = false, length = 255)
////    private String fileName;
////
////    @Column(name = "FilePath", nullable = false, length = 255)
////    private String filePath;
////
////    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "Task_ID", referencedColumnName = "Task_ID")
////    private Task task;
////
////    // Getters and Setters
////    public Integer getAttachmentId() {
////        return attachmentId;
////    }
////
////    public void setAttachmentId(Integer attachmentId) {
////        this.attachmentId = attachmentId;
////    }
////
////    public String getFileName() {
////        return fileName;
////    }
////
////    public void setFileName(String fileName) {
////        this.fileName = fileName;
////    }
////
////    public String getFilePath() {
////        return filePath;
////    }
////
////    public void setFilePath(String filePath) {
////        this.filePath = filePath;
////    }
////
////    public Task getTask() {
////        return task;
////    }
////
////    public void setTask(Task task) {
////        this.task = task;
////    }
////}
//
//-------
//package com.sprint.demo.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "attachment")
//public class Attachment {
//
//    @Id
//   // @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Attachment_ID")
//    private Integer attachmentId;
//
//    @Column(name = "File_Name", nullable = false, length = 255)
//    private String fileName;
//
//    @Column(name = "File_Path", nullable = false, length = 255)
//    private String filePath;
//
////    @ManyToOne(fetch = FetchType.LAZY) // Ensure correct column name
////    @JoinColumn(name = "Task_ID", referencedColumnName = "taskId") // Reference taskId from Task entity
////    private Task task;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Task_ID", referencedColumnName = "Task_ID") // Matches the primary key in Task
//    private Task task;
//
//
//    // Getters and Setters
//    public Integer getAttachmentId() {
//        return attachmentId;
//    }
//
//    public void setAttachmentId(Integer attachmentId) {
//        this.attachmentId = attachmentId;
//    }
//
//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//
//    public Task getTask() {
//        return task;
//    }
//
//    public void setTask(Task task) {
//        this.task = task;
//    }
//}
