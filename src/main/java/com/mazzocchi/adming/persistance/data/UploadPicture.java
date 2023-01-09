package com.mazzocchi.adming.persistance.data;

import lombok.*;
import org.springframework.web.multipart.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadPicture {
    private MultipartFile myPicture;
}