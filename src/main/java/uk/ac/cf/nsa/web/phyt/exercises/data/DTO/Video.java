package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.Media;

//Video class

public class Video extends Media {

    public Video(int id, String src, String altText, String Type, int exerciseID) {
        super(id, src, altText, Type, exerciseID);
    }

}
