package com.vending.common;

import com.vending.model.Network;
import com.vending.model.NetworksModel;

import java.util.Optional;

public interface NetworkFilter {

    NetworksModel getResponse();

    default Optional<Network> getNetwork(final String name){
        return getResponse().getNetworks().stream().filter(network->network.getName().equals(name)).findFirst();
    }

}
