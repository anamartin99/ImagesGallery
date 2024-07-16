package com.imagesgallery.Services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.imagesgallery.Repositories.IimagesGalleryRepository;
import static org.mockito.Mockito.when;

import com.imagesgallery.Models.ImagesGalleryModels;


@ExtendWith(MockitoExtension.class)
public class ImagesGalleryServicesTest {
    

    @Mock
    private IimagesGalleryRepository  imagesGalleryRepository;

    @InjectMocks
    private ImagesGalleryServices imagesGalleryServices;
    private ImagesGalleryModels imagesGalleryModels;

    @Test
    public void testGetAllImages() {
        List<ImagesGalleryModels> images = Arrays.asList(
            new ImagesGalleryModels(),
            new ImagesGalleryModels()
        
    );

    when(imagesGalleryRepository.findAll()).thenReturn(images);

    List<ImagesGalleryModels> result = imagesGalleryRepository.findAll();

    assertEquals(2, result.size());
   
}
@Test
    public void testGetImagesById() {
        // Mock data
        ImagesGalleryModels imagesGalleryModels = new ImagesGalleryModels();
        imagesGalleryModels.setId(1L);

        // Define behavior of mock
        when(imagesGalleryRepository.findById(imagesGalleryModels.getId())).thenReturn(Optional.of(imagesGalleryModels));
        // Test the service method

        ImagesGalleryModels expected = imagesGalleryServices.getById(id);
    }
}
