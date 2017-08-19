package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.Grade;
import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.Base64ImageEncoder;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Test for {@link StorageItemPersistenceMapper}
 */
@RunWith(MockitoJUnitRunner.class)
public class StorageItemPersistenceMapperTest {

    /** Encoded file url. */
    private String encodedFileUrl = "data:image/png;base64,AQAB";

    /** {@link ListMapper}. */
    private ListMapper listMapper;

    /** {@link StorageItemPersistenceMapper} */
    private StorageItemPersistenceMapper storageItemPersistenceMapper;

    /**
     * Set up.
     */
    @Before
    public void setUp() {
        listMapper = new ListMapper();
        storageItemPersistenceMapper = new StorageItemPersistenceMapperHandler();
    }

    /**
     * Checks full model mapping
     */
    @Test
    public void checkFullModelMap() {

        //Setup

        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setReference("reference");
        storageItemPersistenceModel.setDescription("Name");
        storageItemPersistenceModel.setSize("Size");
        storageItemPersistenceModel.setDateStored(new Date());
        storageItemPersistenceModel.setImage(new byte[]{1, 0, 1});
        storageItemPersistenceModel.setGrade("A");
        storageItemPersistenceModel.setBrand("Brand");
        storageItemPersistenceModel.setPrice(1.2);

        final StorageItem storageItem = new StorageItem();
        storageItem.setDescription(storageItemPersistenceModel.getDescription());
        storageItem.setSize(storageItemPersistenceModel.getSize());
        storageItem.setImage(storageItemPersistenceModel.getImage());
        storageItem.setDateStored(storageItemPersistenceModel.getDateStored());
        storageItem.setPrice(1.2);
        storageItem.setGrade(Grade.A);
        storageItem.setBrand("Brand");

        //Test
        final StorageItemPersistenceModel actualStorageItemPersistenceModel = storageItemPersistenceMapper.mapTo
                (storageItem);

        actualStorageItemPersistenceModel.setReference("reference");

        //Assert
        Assert.assertEquals(storageItemPersistenceModel, actualStorageItemPersistenceModel);
    }

    @Test
    public void checkFullModelMapFrom() {

        //Setup
        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setId(1L);
        storageItemPersistenceModel.setReference("reference");
        storageItemPersistenceModel.setDescription("Name");
        storageItemPersistenceModel.setSize("Size");
        storageItemPersistenceModel.setId(1L);
        storageItemPersistenceModel.setDateStored(new Date());
        storageItemPersistenceModel.setImage(new byte[]{1, 0, 1});
        storageItemPersistenceModel.setGrade("A");
        storageItemPersistenceModel.setBrand("Brand");
        storageItemPersistenceModel.setPrice(1.2);

        final StorageItem storageItem = new StorageItem();
        storageItem.setReference("reference");
        storageItem.setDescription(storageItemPersistenceModel.getDescription());
        storageItem.setSize(storageItemPersistenceModel.getSize());
        storageItem.setImage(storageItemPersistenceModel.getImage());
        storageItem.setImageUrl(encodedFileUrl);
        storageItem.setDateStored(storageItemPersistenceModel.getDateStored());
        storageItem.setGrade(Grade.A);
        storageItem.setBrand("Brand");
        storageItem.setPrice(1.2);

        //Test
        final StorageItem actualStorageItem = storageItemPersistenceMapper.mapFrom(storageItemPersistenceModel);

        //Assertion
        Assert.assertEquals(storageItem, actualStorageItem);

    }

    /**
     * Check null map from test.
     */
    @Test
    public void checkNullMapFrom() {

        //Setup
        final StorageItem storageItem = null;

        //Test
        final StorageItem actualStorageItem = storageItemPersistenceMapper.mapFrom(null);

        //Assert
        Assert.assertEquals(storageItem, actualStorageItem);
    }

    /**
     * Check null map to test.
     */
    @Test
    public void checkNullMapTo() {

        //Setup
        final StorageItemPersistenceModel storageItemPersistenceModel = null;

        //Test
        final StorageItemPersistenceModel actualStorageItemPersistenceModel = storageItemPersistenceMapper.mapTo
                (null);

        //Assert
        Assert.assertEquals(storageItemPersistenceModel, actualStorageItemPersistenceModel);
    }

    @Test
    public void listMapperTest() {

        //Setup
        final StorageItem storageItem = new StorageItem();
        storageItem.setReference("reference");
        storageItem.setDescription("name1");
        final StorageItem storageItem2 = new StorageItem();
        storageItem2.setReference("reference");
        storageItem2.setDescription("name2");

        final List<StorageItem> mappingList = Arrays.asList(storageItem, storageItem2);

        final StorageItemPersistenceModel storageItemPersistenceModel = new StorageItemPersistenceModel();
        storageItemPersistenceModel.setReference("reference");
        storageItemPersistenceModel.setDescription("name1");
        final StorageItemPersistenceModel storageItemPersistenceModel2 = new StorageItemPersistenceModel();
        storageItemPersistenceModel2.setReference("reference");
        storageItemPersistenceModel2.setDescription("name2");

        final List<StorageItemPersistenceModel> mappedList = Arrays.asList(storageItemPersistenceModel,
                                                                           storageItemPersistenceModel2);

        //Test
        final List<StorageItemPersistenceModel> storageItemPersistenceModels = listMapper.mapList
                ((AbstractMapper) storageItemPersistenceMapper, true, mappingList);

        //Assert
        Assert.assertEquals(mappedList, storageItemPersistenceModels);
    }

    /**
     * Base64 encoding image test
     */
    @Test
    public void base64encodeTest() {

        final String encodedFile = Base64ImageEncoder.encodeImageUrl(new byte[]{1, 0, 1});

        Assert.assertEquals(encodedFile, encodedFileUrl);
    }

    /**
     * Null check listmapper.
     */
    @Test
    public void mapNullList() {

        //Test
        final List<StorageItemPersistenceModel> storageItemPersistenceModels = listMapper.mapList
                ((AbstractMapper) storageItemPersistenceMapper, true, null);

        //Assert
        Assert.assertNull(storageItemPersistenceModels);
    }
}
