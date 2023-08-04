package com.example.demo.service.request;

import com.example.demo.model.VideoPlaylist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoSaveRequest {
    private String title;
    private String description;
    private String url;
    private List<VideoPlaylist> list;
}
