package com.app.storage.controller.mapper;

import com.app.storage.controller.model.StorageItemControllerModel;
import com.app.storage.domain.model.Grade;
import com.app.storage.domain.model.StorageItem;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Test for {@link StorageItemControllerMapper}
 */
@RunWith(MockitoJUnitRunner.class)
public class StorageItemControllerMapperTest {

    /** {@link ListMapper} */
    private ListMapper listMapper;

    /** {@link StorageItemControllerMapper} */
    private StorageItemControllerMapper storageItemControllerMapper;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        listMapper = new ListMapper();
        storageItemControllerMapper = new StorageItemControllerMapperHandler();
    }

    /**
     * Map storage item test full model.
     */
    @Test
    public void mapFromStorageItemTest() {

        //Setup
        final StorageItemControllerModel storageItemControllerModel = new StorageItemControllerModel();
        storageItemControllerModel.setDescription("Description");
        storageItemControllerModel.setGrade("A");
        storageItemControllerModel.setBrand("Brand");
        storageItemControllerModel.setSize("Size");
        storageItemControllerModel.setImage(new byte[]{1, 0, 1});

        final StorageItem storageItem = new StorageItem();
        storageItem.setDescription("Description");
        storageItem.setBrand("Brand");
        storageItem.setGrade(Grade.A);
        storageItem.setSize("Size");
        storageItem.setImage(new byte[]{1, 0, 1});

        //test
        final StorageItemControllerModel actualStorageItemControllerModel = storageItemControllerMapper.mapFrom
                (storageItem);

        //Assert
        Assert.assertEquals(storageItemControllerModel, actualStorageItemControllerModel);
    }

    /**
     * Map storage item test full model.
     */
    @Test
    public void mapToStorageItemTest() {

        //Setup
        final StorageItemControllerModel storageItemControllerModel = new StorageItemControllerModel();
        storageItemControllerModel.setDescription("Description");
        storageItemControllerModel.setSize("Size");
        storageItemControllerModel.setImage(new byte[]{1, 0, 1});

        final StorageItem storageItem = new StorageItem();
        storageItem.setDescription("Description");
        storageItem.setSize("Size");
        storageItem.setGrade(Grade.UNKNOWN);
        storageItem.setImage(new byte[]{1, 0, 1});

        //test
        final StorageItem actualStorageItem = storageItemControllerMapper.mapTo(storageItemControllerModel);

        //Assert
        Assert.assertEquals(storageItem, actualStorageItem);
    }

    /**
     * Asserts mapping for null objects
     */
    @Test
    public void checkMapEmptyObject() {
        //Setup
        final StorageItemControllerModel storageItemControllerModel = null;

        //Test
        final StorageItemControllerModel actualStorageItemControllerModel = storageItemControllerMapper
                .mapFrom(null);

        //Assertion
        Assert.assertEquals(storageItemControllerModel, actualStorageItemControllerModel);
    }

    /**
     * ListMapper test.
     */
    @Test
    public void checkMapList() {

        //Setup
        final StorageItem storageItem = new StorageItem();
        storageItem.setDescription("TestName");

        final StorageItemControllerModel storageItemControllerModel = new StorageItemControllerModel();
        storageItemControllerModel.setDescription("TestName");

        //Test
        final List<StorageItemControllerModel> actualList = listMapper.mapList((AbstractMapper)
                                                                                       storageItemControllerMapper,
                                                                               false, Arrays.asList(storageItem));

        //Assert
        Assert.assertEquals(actualList, Arrays.asList(storageItemControllerModel));
    }
}
