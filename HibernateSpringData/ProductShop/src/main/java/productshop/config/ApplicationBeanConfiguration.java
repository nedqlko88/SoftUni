package productshop.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import productshop.utils.ResourceFileReader;
import productshop.utils.ResourceFileReaderImpl;
import productshop.utils.ValidatorUtilImpl;
import productshop.utils.ValidatorUtil;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ResourceFileReader resourceFileReader() {
        return new ResourceFileReaderImpl();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().
                excludeFieldsWithoutExposeAnnotation().
                setPrettyPrinting().
                create();
    }

    @Bean
    public ValidatorUtil validatorUtil() {
        return new ValidatorUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
