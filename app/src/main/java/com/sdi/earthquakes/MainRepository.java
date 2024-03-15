package com.sdi.earthquakes;

import com.sdi.earthquakes.api.EarthquakeJSONResponse;
import com.sdi.earthquakes.api.Feature;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {

    public interface DownloadEqsListener {
        void onEsqDownloaded(List<Earthquake> eqList);
    }

    private List<Earthquake> getEarthquakesWithMoshi(EarthquakeJSONResponse body) {
        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        List<Feature> features = body.getFeatures();
        for (Feature feature: features) {
            String id = feature.getId();
            String place = feature.getProperties().getPlace();
            double magnitude = feature.getProperties().getMagnitude();
            long time = feature.getProperties().getTime();

            double longitude = feature.getGeometry().getLongitude();
            double latitude = feature.getGeometry().getLatitude();

            Earthquake earthquake = new Earthquake(
                    id,
                    place,
                    magnitude,
                    time,
                    longitude,
                    latitude
            );
            earthquakes.add(earthquake);
        }
        return earthquakes;
    }

    public void getEarthquakes(DownloadEqsListener downloadEqsListener) {
        ApiClient.Service service = ApiClient.getInstance().getService();

        service.getEarthquakes().enqueue(new Callback<EarthquakeJSONResponse>() {
            @Override
            public void onResponse(Call<EarthquakeJSONResponse> call, Response<EarthquakeJSONResponse> response) {
                List<Earthquake> eql = getEarthquakesWithMoshi(response.body());
                downloadEqsListener.onEsqDownloaded(eql);
            }

            @Override
            public void onFailure(Call<EarthquakeJSONResponse> call, Throwable t) {

            }
        });
    }

}
