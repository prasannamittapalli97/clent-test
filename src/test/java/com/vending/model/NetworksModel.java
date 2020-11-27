package com.vending.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vending.model.Network;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworksModel {

  List<Network> networks;
}
