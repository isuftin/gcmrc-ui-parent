package gov.usgs.cida.gcmrcservices.mb.service;

import gov.usgs.cida.gcmrcservices.TSVUtil;
import gov.usgs.cida.gcmrcservices.mb.model.BedSedimentDownload;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author kmschoep
 */
public class BedSedimentDownloadService {
	private static final Logger log = LoggerFactory.getLogger(BedSedimentDownloadService.class);
	public static enum COLUMNS {STATION_NAME, STATION_NUM, BED_DT, BED_TM, SAMPLE_SET, NOTES, STATION_LOCATION, SAMPLE_WEIGHT, SAND_D50, FINES_D50, TOTAL_D50, PCT_BTWN_063_125, SIZE_DIST_LT_037, SIZE_DIST_LT_044, SIZE_DIST_LT_053, SIZE_DIST_LT_063, SIZE_DIST_LT_074, SIZE_DIST_LT_088, SIZE_DIST_LT_105, SIZE_DIST_LT_125, SIZE_DIST_LT_149, SIZE_DIST_LT_177, SIZE_DIST_LT_210, SIZE_DIST_LT_250, SIZE_DIST_LT_297, SIZE_DIST_LT_354, SIZE_DIST_LT_420, SIZE_DIST_LT_500, SIZE_DIST_LT_595, SIZE_DIST_LT_707, SIZE_DIST_LT_841, SIZE_DIST_LT_1_00, SIZE_DIST_LT_1_41, SIZE_DIST_LT_2_00, SIZE_DIST_LT_2_80, SIZE_DIST_LT_4_00, SIZE_DIST_LT_5_60, SIZE_DIST_LT_8_00, SIZE_DIST_LT_11_3, SIZE_DIST_LT_16_0, SIZE_DIST_LT_22_6, SIZE_DIST_LT_32_0, SIZE_DIST_LT_45_0, SIZE_DIST_LT_64_0, SIZE_DIST_LT_91_0, SIZE_DIST_LT_128_0};
	
	private static Pair<List<String>, List<List<String>>> getBedSedimentDownloadData(List<BedSedimentDownload> data, List<COLUMNS> outputColumns){
		List<List<String> > columns = new ArrayList<>();
		List<String> headers = new ArrayList<>();
		String[] COLUMN_HEADERS = {"Station name", "Station #", "date", "time (" + data.get(0).getTime_zone() +")", "Sample set", "NOTES", "station location (ft)", "sample mass (g)", "Sand D50 (mm)", "Sand, silt, and clay D50 (mm)", "Total sample D50 (mm)", "% of sand finer than 0.125 mm", "%< 0.037 mm", "%< 0.044 mm", "%< 0.053 mm", "%< 0.063 mm", "%< 0.074 mm", "%< 0.088 mm", "%< 0.105 mm", "%< 0.125 mm", "%< 0.149 mm", "%< 0.177 mm", "%< 0.210 mm", "%< 0.250 mm", "%< 0.297 mm", "%< 0.354 mm", "%< 0.420 mm", "%< 0.500 mm", "%< 0.595 mm", "%< 0.707 mm", "%< 0.841 mm", "%< 1.00 mm", "%< 1.41 mm", "%< 2.0 mm", "%< 2.8 mm", "%< 4.0 mm", "%< 5.6 mm", "%< 8.0 mm", "%< 11.3 mm", "%< 16.0 mm ", "%< 22.6 mm ", "%< 32.0 mm", "%<45.0 mm", "%< 64.0 mm", "%< 91.0 mm", "%< 128.0 mm"};
		
		//Build headers and extract relevant data
		for(int i = 0; i < outputColumns.size(); i++){

			headers.add(COLUMN_HEADERS[outputColumns.get(i).ordinal()]);
			
			switch(outputColumns.get(i)){
				case STATION_NAME:
					columns.add(data.stream()
							.map(BedSedimentDownload::getStation_name)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case STATION_NUM:
					columns.add(data.stream()
							.map(BedSedimentDownload::getStation_num)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case BED_DT:
					columns.add(data.stream()
							.map(BedSedimentDownload::getBed_dt)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case BED_TM:
					columns.add(data.stream()
							.map(BedSedimentDownload::getBed_tm)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SAMPLE_SET: 
					columns.add(data.stream()
							.map(BedSedimentDownload::getSample_set)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case NOTES:
					columns.add(data.stream()
							.map(e -> (e.getNotes() == null ? "" : e.getNotes() ))
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case STATION_LOCATION:
					columns.add(data.stream()
							.map(BedSedimentDownload::getStation_location)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SAMPLE_WEIGHT:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSample_weight)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SAND_D50:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSand_d50)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case FINES_D50:
					columns.add(data.stream()
							.map(BedSedimentDownload::getFines_d50)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case TOTAL_D50:
					columns.add(data.stream()
							.map(BedSedimentDownload::getTotal_d50)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case PCT_BTWN_063_125: 
					columns.add(data.stream()
							.map(BedSedimentDownload::getPct_btwn_063_125)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_037:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_037)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_044:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_044)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_053:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_053)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_063:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_063)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_074:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_074)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_088:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_088)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_105:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_105)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_125:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_125)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_149:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_149)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_177:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_177)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_210:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_210)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_250:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_250)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_297:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_297)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_354:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_354)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_420:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_420)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_500:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_500)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_595:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_595)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_707:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_707)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_841:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_841)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_1_00:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_1_00)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_1_41:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_1_41)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_2_00:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_2_00)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_2_80:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_2_80)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_4_00:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_4_00)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_5_60:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_5_60)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_8_00:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_8_00)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_11_3:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_11_3)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_16_0:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_16_0)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_22_6:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_22_6)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_32_0:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_32_0)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_45_0:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_45_0)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_64_0:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_64_0)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_91_0:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_91_0)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				case SIZE_DIST_LT_128_0:
					columns.add(data.stream()
							.map(BedSedimentDownload::getSize_dist_lt_128_0)
							.map(r ->  (r != null ? r.toString() : ""))
							.collect(Collectors.toList()));
					break;
				default:
					log.warn("Un-mapped column found when building Bed Sediment download: " + outputColumns.get(i));
					break;
			}
		}
		
		//Build output
		return new ImmutablePair<List<String>, List<List<String>>>(headers, columns);
	}
	
	public static String getTSVForBedSedimentDownload(List<BedSedimentDownload> data, List<COLUMNS> outputColumns) {		
		List<List<String> > columns = new ArrayList<>();
		List<String> headers = new ArrayList<>();
		String output;
		
		//Get all necessary data
		if(!data.isEmpty()) {
			Pair<List<String>, List<List<String>>> result = getBedSedimentDownloadData(data, outputColumns);
			headers = result.getLeft();
			columns = result.getRight();
		}		
						
		//Verify Data
		if(columns.size() > 0 && headers.size() > 0){
			output = TSVUtil.createTSV(headers, columns, data.size(), false, true);
		} else {
			output = "NO BED SEDIMENT DATA RETURNED FOR SPECIFIED PARAMETERS";
		}
				
		//Create TSV File
		return output;
	}
	
}
