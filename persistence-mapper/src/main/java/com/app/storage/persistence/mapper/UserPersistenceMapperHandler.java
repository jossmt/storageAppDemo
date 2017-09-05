package com.app.storage.persistence.mapper;

import com.app.storage.domain.model.User;
import com.app.storage.persistence.mapper.constants.AbstractMapper;
import com.app.storage.persistence.mapper.constants.ListMapper;
import com.app.storage.persistence.mapper.payment.PaymentInformationPersistenceMapper;
import com.app.storage.persistence.mapper.trade.TradingAccountPersistenceMapper;
import com.app.storage.persistence.model.UserPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link UserPersistenceMapper}
 */
@Component
public class UserPersistenceMapperHandler implements UserPersistenceMapper, AbstractMapper<UserPersistenceModel, User> {

    /** Logger. */
    private static final Logger LOG = LoggerFactory.getLogger(UserPersistenceMapper.class);

    /** {@link RolePersistenceMapper} */
    private RolePersistenceMapper rolePersistenceMapper;

    /** {@link ItemListingPersistenceMapper} */
    private ItemListingPersistenceMapper itemListingPersistenceMapper;

    /** {@link AddressPersistenceMapper}. */
    private AddressPersistenceMapper addressPersistenceMapper;

    /** {@link PaymentInformationPersistenceMapper}. */
    private PaymentInformationPersistenceMapper paymentInformationPersistenceMapper;

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

            if (user.getItemListings() != null) {
                userPersistenceModel
                        .setItemListingPersistenceModelList(listMapper.mapList((AbstractMapper)
                                                                                       itemListingPersistenceMapper,
                                                                               true, user.getItemListings()));
            }

            if (user.getAddressList() != null) {
                userPersistenceModel.setAddressPersistenceModels(listMapper.mapList((AbstractMapper)
                                                                                            addressPersistenceMapper,
                                                                                    true,
                                                                                    user.getAddressList()));
            }
            if (user.getPaymentInformation() != null) {
                userPersistenceModel.setPaymentInformationPersistenceModel(
                        paymentInformationPersistenceMapper.mapTo(user.getPaymentInformation()));
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

            if (userPersistenceModel.getItemListingPersistenceModelList() != null) {
                user.setItemListings(listMapper.mapList((AbstractMapper) itemListingPersistenceMapper, false,
                                                        userPersistenceModel.getItemListingPersistenceModelList()));
            }

            if (userPersistenceModel.getAddressPersistenceModels() != null) {
                user.setAddressList(listMapper.mapList((AbstractMapper) addressPersistenceMapper, false,
                                                       userPersistenceModel
                                                               .getAddressPersistenceModels()));
            }
            if (userPersistenceModel.getPaymentInformationPersistenceModel() != null) {
                user.setPaymentInformation(paymentInformationPersistenceMapper.mapFrom(
                        userPersistenceModel.getPaymentInformationPersistenceModel()));
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
     * Sets new {@link ItemListingPersistenceMapper}.
     *
     * @param itemListingPersistenceMapper
     *         New value of {@link ItemListingPersistenceMapper}.
     */
    @Autowired
    public void setItemListingPersistenceMapper(ItemListingPersistenceMapper itemListingPersistenceMapper) {
        this.itemListingPersistenceMapper = itemListingPersistenceMapper;
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
     * Sets new {@link AddressPersistenceMapper}..
     *
     * @param addressPersistenceMapper
     *         New value of {@link AddressPersistenceMapper}..
     */
    @Autowired
    public void setAddressPersistenceMapper(AddressPersistenceMapper addressPersistenceMapper) {
        this.addressPersistenceMapper = addressPersistenceMapper;
    }

    /**
     * Sets new {@link PaymentInformationPersistenceMapper}..
     *
     * @param paymentInformationPersistenceMapper
     *         New value of {@link PaymentInformationPersistenceMapper}..
     */
    @Autowired
    public void setPaymentInformationPersistenceMapper(PaymentInformationPersistenceMapper
                                                               paymentInformationPersistenceMapper) {
        this.paymentInformationPersistenceMapper = paymentInformationPersistenceMapper;
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
