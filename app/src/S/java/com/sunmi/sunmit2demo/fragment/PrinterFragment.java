package com.sunmi.sunmit2demo.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sunmi.devicemanager.ICheckDeviceListener;
import com.sunmi.devicemanager.cons.Cons;
import com.sunmi.devicemanager.device.Device;
import com.sunmi.devicesdk.core.DeviceManager;
import com.sunmi.devicesdk.core.PrinterManager;
import com.sunmi.sunmit2demo.BaseFragment;
import com.sunmi.sunmit2demo.R;
import com.sunmi.sunmit2demo.adapter.PrinterAdapter;
import com.sunmi.sunmit2demo.utils.ThreadPoolManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bps .
 */
public class PrinterFragment extends BaseFragment {

    private RecyclerView mRecyclerPrinter;
    private List<Device> mDeviceList = new ArrayList<>();
    private PrinterManager mPrinterManager;
    private PrinterAdapter mAdapter;


    @Override
    protected int setView() {
        return R.layout.fragment_printer;
    }

    @Override
    protected void init(View view) {
        mRecyclerPrinter = view.findViewById(R.id.recycler_printer);
        mPrinterManager = PrinterManager.getInstance();
        mAdapter = new PrinterAdapter(mActivity, mDeviceList);
        mRecyclerPrinter.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerPrinter.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((view1, position) -> {
            if (position == 0) {
                try {
                    DeviceManager.getInstance().startSettingActivity();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    private void getPrinterList() {
        mDeviceList.clear();
        ThreadPoolManager.getsInstance().execute(() -> {
            try {
                List<Device> printerDevice = mPrinterManager.getPrinterDevice();

                mPrinterManager.checkDeviceAsync(printerDevice, new ICheckDeviceListener.Stub() {
                    @Override
                    public void onDeviceChecked(Device device, int i, String s) {
                        mActivity.runOnUiThread(() -> {
                            if (device.type == Cons.Type.PRINT && device.connectType == Cons.ConT.INNER) {
                                return;
                            }
                            mDeviceList.add(device);
                            mAdapter.replaceData(mDeviceList);
                        });
                    }

                    @Override
                    public void onComplete() {
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getPrinterList();
    }
}
