package ro.ubb.mappers;

import ro.ubb.dtos.RegionDto;
import ro.ubb.models.Region;

public class RegionDtoMapper {
    public static Region mapRegionDtoToRegion(RegionDto regionDto) {
        Region region = new Region();
        region.setName(regionDto.getName());
        return region;
    }

    public static RegionDto mapRegionToRegionDto(Region region){
        RegionDto regionDto = new RegionDto();
        regionDto.setName(region.getName());
        return regionDto;
    }
}
