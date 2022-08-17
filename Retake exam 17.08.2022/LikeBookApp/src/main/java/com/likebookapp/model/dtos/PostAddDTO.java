package com.likebookapp.model.dtos;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.MoodType;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostAddDTO {

    @NotNull
    @Size(min = 2, max = 150)
    private String content;

    @NotNull
    private MoodType moodType;

    public PostAddDTO() {}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodType getMoodType() {
        return moodType;
    }

    public void setMoodType(MoodType moodType) {
        this.moodType = moodType;
    }
}
