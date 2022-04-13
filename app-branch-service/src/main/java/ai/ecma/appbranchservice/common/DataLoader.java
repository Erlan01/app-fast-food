package ai.ecma.appbranchservice.common;

import ai.ecma.appbranchservice.exception.RestException;
import ai.ecma.lib.entity.District;
import ai.ecma.lib.entity.Region;
import ai.ecma.lib.repository.DistrictRepository;
import ai.ecma.lib.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Osiyo Adilova
 * @project app-eticket-server
 * @since 12/16/2021
 */

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RegionRepository regionRepository;
    private final DistrictRepository districtRepository;

    @Value("${spring.sql.init.mode}")
    private String initialMode;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            List<Region> regions = new ArrayList<>();
            regions.add(new Region("Toshkent"));
            regions.add(new Region("Toshkent viloyati"));
            regions.add(new Region("Andijon viloyati"));
            regions.add(new Region("Farg'ona viloyati"));
            regions.add(new Region("Namangan viloyati"));
            regions.add(new Region("Sirdaryo viloyati"));
            regions.add(new Region("Jizzax viloyati"));
            regions.add(new Region("Qashqadaryo viloyati"));
            regions.add(new Region("Surxondaryo viloyati"));
            regions.add(new Region("Samarqand viloyati"));
            regions.add(new Region("Navoiy viloyati"));
            regions.add(new Region("Buxoro viloyati"));
            regions.add(new Region("Xorazm viloyati"));
            regions.add(new Region("Qoraqalpog'iston Respublikasi"));

            regionRepository.saveAll(regions);

            String[] districts = new String[]{
                    "Bekabad",
                    "Bostanliq",
                    "Buka",
                    "Chinaz",
                    "Qibray",
                    "Okhangaron",
                    "Oqqurgan",
                    "Parkent",
                    "Piskent",
                    "Quyi",
                    "Zangiata",
                    "Orta",
                    "Yangiyol",
                    "YukoriYangibozor",
            };

            Region region = regionRepository.findByName("Toshkent viloyati").orElseThrow(() -> RestException.notFound("REGION"));

            List<District> districtList = new ArrayList<>();
            for (String district : districts) {
                districtList.add(
                        new District(district, region)
                );
            }
            districtRepository.saveAll(districtList);


        } else {
        }

        System.err.printf("Sql init mode is %s \n", initialMode);
    }
}

