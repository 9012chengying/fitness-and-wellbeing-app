package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.MediaEntity;

public class Image extends MediaEntity {

    public Image(int id, String src, String altText, String Type, int exerciseID) {

        super(id, src, altText, Type, exerciseID);

    }

}
