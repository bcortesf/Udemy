import { Capital } from "./capital.interface";
import { Country } from "./country.interface";
import { Region } from "./region.interface";
import { RegionType } from "./region.type";

export interface CacheStore {
  byCapital: TermCapitals;
  byCountry: TermCountries;
  byRegion: RegionCountries
}

export interface TermCapitals {
  term: string;
  capitals: Capital[];
}
export interface TermCountries {
  term: string;
  countries: Country[];
}
export interface RegionCountries {
  regionSelected?: RegionType;
  regions: Region[];
}
