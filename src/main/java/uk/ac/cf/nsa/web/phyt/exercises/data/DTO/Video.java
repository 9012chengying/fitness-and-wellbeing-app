package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.MediaEntity;

public class Video extends MediaEntity {

    public Video(int id, String src, String altText, String Type, int exerciseID) {
        super(id, src, altText, Type, exerciseID);
    }

}
