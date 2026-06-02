////	package com.GuruFruit.controller;
////	
////	import org.springframework.http.ResponseEntity;
////	import org.springframework.web.bind.annotation.*;
////	import org.springframework.web.multipart.MultipartFile;
////	
////	import java.io.File;
////	import java.io.IOException;
////	import java.nio.file.Files;
////	import java.nio.file.Path;
////	import java.nio.file.Paths;
////	
////	@RestController
////	@RequestMapping("/api/upload")
////	@CrossOrigin("*")
////	public class ImageUploadController {
////	
////	    private final String UPLOAD_DIR = "uploads/";
////	
////	    @PostMapping
////	    public ResponseEntity<?> uploadImage(
////	            @RequestParam("file") MultipartFile file
////	    ) {
////	
////	        try {
////	
////	            File dir = new File(UPLOAD_DIR);
////	
////	            if (!dir.exists()) {
////	                dir.mkdirs();
////	            }
////	
////	            String fileName =
////	                    System.currentTimeMillis()
////	                            + "_"
////	                            + file.getOriginalFilename();
////	
////	            Path path =
////	                    Paths.get(UPLOAD_DIR + fileName);
////	
////	            Files.write(path, file.getBytes());
////	
////	            String imageUrl =
////	                    "http://localhost:8080/uploads/"
////	                            + fileName;
////	
////	            return ResponseEntity.ok(imageUrl);
////	
////	        } catch (IOException e) {
////	
////	            return ResponseEntity
////	                    .badRequest()
////	                    .body("Upload Failed");
////	        }
////	    }
////	}
//
////package com.GuruFruit.controller;
////
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////import org.springframework.web.multipart.MultipartFile;
////
////import java.io.File;
////import java.io.IOException;
////import java.nio.file.Files;
////import java.nio.file.Path;
////import java.nio.file.Paths;
////
////@RestController
////@RequestMapping("/api/upload")
////@CrossOrigin("*")
////public class ImageUploadController {
////
////    private final String UPLOAD_DIR = "uploads/";
////
////    @PostMapping
////    public ResponseEntity<?> uploadImage(
////            @RequestParam("file") MultipartFile file
////    ) {
////
////        try {
////
////            File dir = new File(UPLOAD_DIR);
////
////            if (!dir.exists()) {
////                dir.mkdirs();
////            }
////
////            String fileName =
////                    System.currentTimeMillis()
////                            + "_"
////                            + file.getOriginalFilename();
////
////            Path path =
////                    Paths.get(UPLOAD_DIR + fileName);
////
////            Files.write(path, file.getBytes());
////
////            // IMPORTANT FIX ✅
////
////            String imageUrl =
//////                    "/uploads/" + fileName;
////            		"http://localhost:8080/uploads/"+fileName;
////
////            return ResponseEntity.ok(imageUrl);
////
////        } catch (IOException e) {
////
////            return ResponseEntity
////                    .badRequest()
////                    .body("Upload Failed");
////        }
////    }
////}
//package com.GuruFruit.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@RestController
//@RequestMapping("/api/upload")
//@CrossOrigin("*")
//public class ImageUploadController {
//
//    private final String UPLOAD_DIR = "uploads/";
//
//    @PostMapping
//    public ResponseEntity<?> uploadImage(
//            @RequestParam("file") MultipartFile file
//    ) {
//
//        try {
//
//            // Create uploads folder if not exists
//            File dir = new File(UPLOAD_DIR);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//
//            // Unique file name
//            String fileName =
//                    System.currentTimeMillis()
//                            + "_"
//                            + file.getOriginalFilename();
//
//            // Save file locally
//            Path path = Paths.get(UPLOAD_DIR + fileName);
//            Files.write(path, file.getBytes());
//
//            // ✅ PRODUCTION FIX (NO localhost)
//            String imageUrl =
//                    ServletUriComponentsBuilder
//                            .fromCurrentContextPath()
//                            .path("/uploads/")
//                            .path(fileName)
//                            .toUriString();
//
//            return ResponseEntity.ok(imageUrl);
//
//        } catch (IOException e) {
//            return ResponseEntity
//                    .badRequest()
//                    .body("Upload Failed: " + e.getMessage());
//        }
//    }
//}
//}
