package com.chinadci.backendservice.common.service;

import com.chinadci.backendservice.common.entity.ReturnCountAndObjects;
import com.chinadci.backendservice.data.model.RegisteredDevices;
import com.chinadci.backendservice.data.model.TotalDevice;
import com.chinadci.backendservice.model.AppDevice;
import com.chinadci.backendservice.model.ServiceObjectResult;
import com.chinadci.backendservice.model.ServiceResult;

public interface DeviceService {
    ServiceObjectResult<ReturnCountAndObjects<AppDevice>> getList(Integer index, Integer size, Short status, String query);

    ServiceObjectResult<AppDevice> getDevice(int id);

    ServiceObjectResult<Integer> UpdateCheck(RegisteredDevices registeredDevices);

    ServiceObjectResult<Integer> UpdateStatus(RegisteredDevices registeredDevices);

    ServiceObjectResult<TotalDevice> getCount();
}
