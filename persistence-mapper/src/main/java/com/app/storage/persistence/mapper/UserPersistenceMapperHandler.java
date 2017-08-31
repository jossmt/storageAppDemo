package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.StorageItem;
import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.mapper.payment.BillingAddressPersistenceMapper;
import com.app.storage.persistence.mapper.payment.CardInformationPersistenceMapper;
import com.app.storage.persistence.mapper.trade.TradingAccountPersistenceMapper;
import com.app.storage.persistence.model.StorageItemPersistenceModel;
import com.app.storage.persistence.model.UserPersistenceModel;
import com.app.storage.persistence.model.payment.CardInformationPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementation of {@link UserPersistenceMapper}
 */
@Component
public class UserPersistenceMapperHandler implements UserPersistenceMapper, AbstractMapper<UserPersistenceModel, User> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(UserPersistenceMapper.class);

    /** {@link StorageItemPersistenceModel}. */
    private List<StorageItemPersistenceModel> storageItemPersistenceModels;

    /** {@link StorageItem}. */
    private List<StorageItem> storageItems;

    /** {@link RolePersistenceMapper} */
    private RolePersistenceMapper rolePersistenceMapper;

    /** {@link StorageItemPersistenceMapper} */
    private StorageItemPersistenceMapper storageItemPersistenceMapper;

    /** {@link BillingAddressPersistenceMapper}. */
    private BillingAddressPersistenceMapper billingAddressPersistenceMapper;

    /** {@link CardInformationPersistenceMapper}. */
    private CardInformationPersistenceMapper cardInformationPersistenceMapper;

    /** {@link TradingAccountPersistenceMapper}. */
    private TradingAccountPersistenceMapper tradingAccountPersistenceMapper;

    /** {@link ListMapper}. */
    private ListMapper listMapper;

    /**
     * Constructor.
     *
     * @param listMapper
     *         {@link ListMapper}
     */
    @Autowired
    public UserPersistenceMapperHandler(final ListMapper listMapper) {
        this.listMapper = listMapper;
    }

    /**
     * {@inheritDoc}
     */
    public UserPersistenceModel mapTo(final User user) {

        LOG.debug("Mapping user to persistence model.");

        UserPersistenceModel userPersistenceModel = null;
        if (user != null) {
            userPersistenceModel = new UserPersistenceModel();

            userPersistenceModel.setEmail(user.getEmail());
            userPersistenceModel.setFirstName(user.getFirstName());
            userPersistenceModel.setLastName(user.getLastName());
            userPersistenceModel.setPassword(user.getPassword());
            userPersistenceModel.setRoles(listMapper.mapList((AbstractMapper) rolePersistenceMapper,
                                                             true, user.getRoles()));

            if (storageItemPersistenceModels != null) {
                userPersistenceModel.setStorageItemPersistenceModelList(storageItemPersistenceModels);
            } else if (user.getStorageItems() != null) {
                storageItemPersistenceMapper.setUserPersistenceModel(userPersistenceModel);
                userPersistenceModel
                        .setStorageItemPersistenceModelList(listMapper.mapList((AbstractMapper)
                                                                                       storageItemPersistenceMapper,
                                                                               true, user.getStorageItems()));
            }

            if (user.getBillingAddress() != null) {
                userPersistenceModel.setBillingAddressPersistenceModel(billingAddressPersistenceMapper
                                                                               .mapTo(user.getBillingAddress()));
            }
            if (user.getPaymentDetails() != null) {
                userPersistenceModel.setCardInformationPersistenceModels(listMapper.mapList((AbstractMapper)
                                                                                                    cardInformationPersistenceMapper,
                                                                                            true, user
                                                                                                    .getPaymentDetails()));
            }

            if (user.getTradingAccounts() != null) {
                userPersistenceModel.setTradingAccountPersistenceModelList(listMapper.mapList((AbstractMapper)
                                                                                                      tradingAccountPersistenceMapper,
                                                                                              true, user
                                                                                                      .getTradingAccounts()));
            }
        }

        LOG.debug("Successfully mapped user to persistence model");

        return userPersistenceModel;
    }

    /**
     * {@inheritDoc}
     */
    public User mapFrom(final UserPersistenceModel userPersistenceModel) {

        LOG.debug("Mapping user persistence model to domain model.");

        User user = null;
        if (userPersistenceModel != null) {

            user = new User();
            user.setEmail(userPersistenceModel.getEmail());
            user.setFirstName(userPersistenceModel.getFirstName());
            user.setLastName(userPersistenceModel.getLastName());
            user.setPassword(userPersistenceModel.getPassword());
            user.setRoles(listMapper.mapList((AbstractMapper) rolePersistenceMapper, false,
                                             userPersistenceModel.getRoles()));

            if (storageItems != null) {
                user.setStorageItems(storageItems);
            } else if (userPersistenceModel.getStorageItemPersistenceModelList() != null) {
                storageItemPersistenceMapper.setUserModel(user);
                user.setStorageItems(listMapper.mapList((AbstractMapper) storageItemPersistenceMapper, false,
                                                        userPersistenceModel.getStorageItemPersistenceModelList()));
            }

            if (userPersistenceModel.getBillingAddressPersistenceModel() != null) {
                user.setBillingAddress(billingAddressPersistenceMapper.mapFrom(userPersistenceModel
                                                                                       .getBillingAddressPersistenceModel()));
            }
            if (userPersistenceModel.getCardInformationPersistenceModels() != null) {
                user.setPaymentDetails(listMapper.mapList((AbstractMapper) cardInformationPersistenceMapper, false,
                                                          userPersistenceModel.getCardInformationPersistenceModels()));
            }

            if (userPersistenceModel.getTradingAccountPersistenceModelList() != null) {
                user.setTradingAccounts(listMapper.mapList((AbstractMapper) tradingAccountPersistenceMapper, false,
                                                           userPersistenceModel
                                                                   .getTradingAccountPersistenceModelList()));
            }
        }

        LOG.debug("Successfully mapped persistence model to domain model.");

        return user;
    }

    /**
     * Sets new {@link StorageItemPersistenceMapper}.
     *
     * @param storageItemPersistenceMapper
     *         New value of {@link StorageItemPersistenceMapper}.
     */
    @Autowired
    public void setStorageItemPersistenceMapper(StorageItemPersistenceMapper storageItemPersistenceMapper) {
        this.storageItemPersistenceMapper = storageItemPersistenceMapper;
    }

    /**
     * Sets new {@link RolePersistenceMapper}.
     *
     * @param rolePersistenceMapper
     *         New value of {@link RolePersistenceMapper}.
     */
    @Autowired
    public void setRolePersistenceMapper(RolePersistenceMapper rolePersistenceMapper) {
        this.rolePersistenceMapper = rolePersistenceMapper;
    }

    /**
     * Sets new {@link BillingAddressPersistenceMapper}..
     *
     * @param billingAddressPersistenceMapper
     *         New value of {@link BillingAddressPersistenceMapper}..
     */
    @Autowired
    public void setBillingAddressPersistenceMapper(BillingAddressPersistenceMapper billingAddressPersistenceMapper) {
        this.billingAddressPersistenceMapper = billingAddressPersistenceMapper;
    }

    /**
     * Sets new {@link CardInformationPersistenceMapper}..
     *
     * @param cardInformationPersistenceMapper
     *         New value of {@link CardInformationPersistenceMapper}..
     */
    @Autowired
    public void setCardInformationPersistenceMapper(CardInformationPersistenceMapper cardInformationPersistenceMapper) {
        this.cardInformationPersistenceMapper = cardInformationPersistenceMapper;
    }

    /**
     * Sets new {@link TradingAccountPersistenceMapper}..
     *
     * @param tradingAccountPersistenceMapper
     *         New value of {@link TradingAccountPersistenceMapper}..
     */
    @Autowired
    public void setTradingAccountPersistenceMapper(TradingAccountPersistenceMapper tradingAccountPersistenceMapper) {
        this.tradingAccountPersistenceMapper = tradingAccountPersistenceMapper;
    }
}
