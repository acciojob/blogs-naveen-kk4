package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        Optional<Blog> blogOptional = blogRepository2.findById(blogId);

         Image image = new Image();
         image.setDescription(description);
         image.setDimensions(dimensions);
         if(blogOptional.isEmpty()){
             imageRepository2.save(image);
             return image;
         }
         Blog blog = blogOptional.get();
         image.setBlog(blog);
        image = imageRepository2.save(image);

       blog.getImageList().add(image);
       blogRepository2.save(blog);
       return image;


    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Optional<Image> imageOptional = imageRepository2.findById(id);
        if(imageOptional.isEmpty())return 0;
        Image image = imageOptional.get();
         String str = image.getDimensions();
         String arr1[] = str.split("X");
         String arr2[] = screenDimensions.split("X");
        return (Integer.valueOf(arr2[0])/Integer.valueOf(arr1[0])) * (Integer.valueOf(arr2[1])/Integer.valueOf(arr1[1])) ;

    }
}
