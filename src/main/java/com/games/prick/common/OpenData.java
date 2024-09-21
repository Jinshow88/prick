package com.games.prick.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class OpenData {

    public final String openDate;

    public OpenData(@Value("${file.directory}") String openDate) {
        this.openDate = openDate;
    }
    public void publicDate( )

}
