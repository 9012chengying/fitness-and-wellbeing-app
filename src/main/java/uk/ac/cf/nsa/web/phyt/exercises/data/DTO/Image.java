package uk.ac.cf.nsa.web.phyt.exercises.data.DTO;

import uk.ac.cf.nsa.web.phyt.model.MediaEntity;

//Image class
public class Image extends MediaEntity {

    public Image(int id, String src, String altText, String Type, int exerciseID) {
        super(id, src, altText, Type, exerciseID);
    }

    public Image (String src, String altText, String Type, int exerciseID){
     super(src, altText, Type,exerciseID);
    }

}
