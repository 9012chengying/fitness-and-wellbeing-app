package uk.ac.cf.nsa.web.phyt.exercises.forms;

import java.sql.Blob;

public class ImageForm {

    Blob thumbnailImage;
    Blob image1;
    Blob image2;
    Blob image3;

    public ImageForm() {
    }



    public ImageForm(Blob thumbnailImage, Blob image1, Blob image2, Blob image3) {
        this.thumbnailImage = thumbnailImage;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public ImageForm(Blob image1, Blob image2, Blob image3) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public ImageForm(Blob image1, Blob image2) {
        this.image1 = image1;
        this.image2 = image2;
    }

    public ImageForm(Blob image1) {
        this.image1 = image1;
    }
}
