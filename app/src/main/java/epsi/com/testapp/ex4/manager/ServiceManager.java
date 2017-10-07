package epsi.com.testapp.ex4.manager;

/**
 * Created by mlagast on 07/10/2017.
 */

import okhttp3.Request;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mlagast on 04/08/2017.
 */

public class ServiceManager {
    public static final String API_BASE_URL = "https://api.trakt.tv";
    public static final String API_TOKEN = "f45ba41514e3d5c19baa61759bbddd62a291160210ecb4888d9dc5e2707a1b7c";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        return createService(serviceClass, API_TOKEN);
    }

    public static <S> S createService(Class<S> serviceClass, final String apiToken) {
        if (apiToken != null) {
            httpClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .header("trakt-api-version", "2")
                            .header("trakt-api-key", apiToken)
                            .method(original.method(), original.body());

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            });
        }

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(logging);

        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }

}
