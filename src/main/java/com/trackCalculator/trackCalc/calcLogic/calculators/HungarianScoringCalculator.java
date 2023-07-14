package com.trackCalculator.trackCalc.calcLogic.calculators;


import com.trackCalculator.trackCalc.calcLogic.util.TimeConversions;

import java.io.*;
import java.util.HashMap;
import java.util.function.Function;

public final class HungarianScoringCalculator {


    static{
        constantsHashMap = new HashMap<>();
        prepareMap();
    }


    //where all the constants are stored
    private static final HashMap<String, Constants> constantsHashMap;

    private HungarianScoringCalculator() {}

    public static Float getScore(String gender, String location, String event, Float performance, Integer hours, Integer minutes,
    Float seconds, boolean isField){

        if(isField){
            return getScore(gender, location, event, performance);
        }
        else{
            return getScore(gender, location, event, hours, minutes, seconds);
        }

    }




    //for field events
    private static Float getScore(String gender, String location, String event, Float performance){

        String formattedEventString = getFormattedEventString(gender, event, location);
        return constantsHashMap.get(formattedEventString).getScoreFunc.apply(performance);
    }

    //for timed events
    private static Float getScore(String gender, String location, String event, Integer hours, Integer minutes, Float seconds){

        float totalSeconds = TimeConversions.convertToSeconds(hours, minutes, seconds);

        String formattedEventString = getFormattedEventString(gender, event, location);
        return constantsHashMap.get(formattedEventString).getScoreFunc.apply(totalSeconds);
    }


    public static String getPerformance(String gender, String location, String event, Float score){

        String formattedEventString = getFormattedEventString(gender, event, location);

        Constants constants = constantsHashMap.get(formattedEventString);

        //for field events
        if(constants.isField){
            return Float.toString(constants.getPerformanceFunc.apply(score));
        }

        //for timed events
        Float timeInSeconds = constants.getPerformanceFunc.apply(score);
        return TimeConversions.convertToFullTime(timeInSeconds);

    }



    private static String getFormattedEventString(String gender, String location, String event){

        StringBuilder string = new StringBuilder();

        if(gender.equals("male")){
            string.append("male");
        }
        else{
            string.append("female");
        }

        string.append(event);
        string.append(location);

        return string.toString();
    }


    private static void prepareMap() {

        // Women Indoor
        addData("TRACK_50", "femaleIndoor", 33.0462434523f, -12.0979307449f, -0.2321096149f);
        addData("TRACK_50H", "femaleIndoor", 16.2126653261f, -15.2953835346f, -0.1053761359f);
        addData("TRACK_55", "femaleIndoor", 27.6922288869f, -13.1481380284f, -0.3043705117f);
        addData("TRACK_55H", "femaleIndoor", 13.1982215478f, -16.7954274775f, -0.0911772754f);
        addData("TRACK_60", "femaleIndoor", 24.9117754427f, -13.9976515376f, -0.2293776923f);
        addData("TRACK_60H", "femaleIndoor", 11.1682818890f, -18.1940019446f, 0.0085061498f);
        addData("TRACK_200", "femaleIndoor", 1.9616411646f, -47.4976950867f, -0.0697455752f);
        addData("TRACK_300", "femaleIndoor", 0.6595165231f, -78.9940494903f, 0.0176083216f);
        addData("TRACK_400", "femaleIndoor", 0.3223966170f, -111.9954899416f, -0.0058333313f);
        addData("TRACK_500", "femaleIndoor", 0.1713990152f, -150.4950203151f, 0.0051908612f);
        addData("TRACK_600", "femaleIndoor", 0.1063013220f, -190.3440098081f, 0.0091340263f);
        addData("TRACK_800", "femaleIndoor", 0.0572001165f, -263.9946646628f, 0.0030507986f);
        addData("TRACK_1000", "femaleIndoor", 0.0347303143f, -340.3940084944f, 0.0038176306f);
        addData("TRACK_1500", "femaleIndoor", 0.0136499412f, -539.9956644344f, -0.0008961974f);
        addData("TRACK_1MILE", "femaleIndoor", 0.0115400273f, -585.4943375501f, 0.0016038837f);
        addData("TRACK_2000", "femaleIndoor", 0.0068499998f, -752.1949210708f, 0.0002786803f);
        addData("TRACK_3000", "femaleIndoor", 0.0025900009f, -1199.9946258953f, 0.0005730322f);
        addData("TRACK_2MILES", "femaleIndoor", 0.0022019898f, -1296.2971509252f, -0.0015550154f);
        addData("TRACK_5000", "femaleIndoor", 0.0008250002f, -2099.9945836524f, 0.0004364654f);
        addData("TRACK_4x200", "femaleIndoor", 0.0825999218f, -211.9949807338f, 0.0007540780f);
        addData("TRACK_4x400", "femaleIndoor", 0.0155000012f, -483.9954080687f, -0.0021634214f);
        addData("HIGH_JUMP", "femaleIndoor", 39.5579087445f, 10.5082093421f, -4969.5880642855f);
        addData("LONG_JUMP", "femaleIndoor", 1.9581140326f, 49.4597044183f, -5024.0505434215f);
        addData("TRIPLE_JUMP", "femaleIndoor", 0.4296645887f, 105.1320544518f, -4980.6423815636f);
        addData("POLE_VAULT", "femaleIndoor", 3.9325797501f, 35.0265857026f, -5029.8531935972f);
        addData("SHOT_PUT", "femaleIndoor", 0.0462143876f, 657.3172794694f, -19993.5978247992f);
        addData("PENTATHLON", "femaleIndoor", 0.0000029452f, 41021.7737084897f, -4998.5983727330f);

        // Men Indoor
        addData("TRACK_50", "maleIndoor", 95.8223538630f, -9.1994010874f, -0.3765978316f);
        addData("TRACK_50H", "maleIndoor", 34.2123772242f, -12.3484992509f, -0.2978589247f);
        addData("TRACK_55", "maleIndoor", 78.9227608846f, -9.9991682963f, -0.3262593216f);
        addData("TRACK_55H", "maleIndoor", 30.0853077082f, -13.3476676416f, -0.2329919571f);
        addData("TRACK_60", "maleIndoor", 68.6203220047f, -10.6992800164f, -0.3594275681f);
        addData("TRACK_60H", "maleIndoor", 23.9163242706f, -14.5966339421f, -0.1644943777f);
        addData("TRACK_200", "maleIndoor", 5.0432159856f, -35.9910107213f, 0.1193936923f);
        addData("TRACK_300", "maleIndoor", 1.8029166507f, -57.9959412461f, -0.0339878087f);
        addData("TRACK_400", "maleIndoor", 0.9810343085f, -80.5943092492f, 0.0100805172f);
        addData("TRACK_500", "maleIndoor", 0.5649640314f, -105.9967162205f, -0.0223133096f);
        addData("TRACK_600", "maleIndoor", 0.3899861153f, -130.9961383961f, -0.0107176039f);
        addData("TRACK_800", "maleIndoor", 0.1973925611f, -183.9969956062f, -0.0163487860f);
        addData("TRACK_1000", "maleIndoor", 0.1138977865f, -239.9960148998f, -0.0046409292f);
        addData("TRACK_1500", "maleIndoor", 0.0419999885f, -385.9950544882f, -0.0003541283f);
        addData("TRACK_1MILE", "maleIndoor", 0.0369000074f, -414.9952787475f, -0.0011489453f);
        addData("TRACK_2000", "maleIndoor", 0.0226000035f, -527.9948971024f, 0.0000435776f);
        addData("TRACK_3000", "maleIndoor", 0.0083219192f, -839.9970746667f, -0.0027639444f);
        addData("TRACK_2MILES", "maleIndoor", 0.0072099692f, -906.9958053163f, -0.0012099440f);
        addData("TRACK_5000", "maleIndoor", 0.0029000031f, -1439.9944442896f, 0.0004079214f);
        addData("TRACK_4x200", "maleIndoor", 0.3119844823f, -143.9971416694f, -0.0252237437f);
        addData("TRACK_4x400", "maleIndoor", 0.0489005767f, -339.9937188583f, 0.0054240683f);
        addData("HIGH_JUMP", "maleIndoor", 32.1457081634f, 11.5936889433f, -5026.0808417004f);
        addData("LONG_JUMP", "maleIndoor", 1.9310928730f, 48.3486190515f, -4993.8077931235f);
        addData("TRIPLE_JUMP", "maleIndoor", 0.4603666024f, 98.8014630138f, -5008.9686647032f);
        addData("POLE_VAULT", "maleIndoor", 3.0457199209f, 39.3358603090f, -4993.2138282251f);
        addData("SHOT_PUT", "maleIndoor", 0.0423461436f, 684.8281542324f, -19915.7245727669f);
        addData("HEPTATHLON", "maleIndoor", 0.0000017511f, 53203.5391079802f, -5002.8876894102f);

        // Women Outdoor
        addData("TRACK_100", "femaleOutdoor", 9.9274264508f, -21.9933700028f, 0.0421329658f);
        addData("TRACK_200", "femaleOutdoor", 2.2422237149f, -45.4938200765f, 0.0245765276f);
        addData("TRACK_300", "femaleOutdoor", 0.6999743364f, -76.9959087143f, -0.0139944400f);
        addData("TRACK_400", "femaleOutdoor", 0.3350059758f, -109.9942273774f, 0.0076554298f);
        addData("TRACK_600", "femaleOutdoor", 0.1191983841f, -183.9955892216f, -0.0026515132f);
        addData("TRACK_800", "femaleOutdoor", 0.0687998934f, -249.9950232947f, -0.0000169472f);
        addData("TRACK_1000", "femaleOutdoor", 0.0381997085f, -329.9958136040f, -0.0021547584f);
        addData("TRACK_1500", "femaleOutdoor", 0.0133999963f, -539.9949703133f, -0.0005396117f);
        addData("TRACK_1MILE", "femaleOutdoor", 0.0116499986f, -579.9949693123f, 0.0004597245f);
        addData("TRACK_2000", "femaleOutdoor", 0.0067660105f, -749.9948524357f, 0.0001847193f);
        addData("TRACK_3000", "femaleOutdoor", 0.0025389975f, -1199.9953765729f, -0.0002368852f);
        addData("TRACK_2MILES", "femaleOutdoor", 0.0021569983f, -1296.2954038511f, -0.0002368758f);
        addData("TRACK_5000", "femaleOutdoor", 0.0008079992f, -2099.9956378883f, -0.0001983631f);
        addData("TRACK_10000", "femaleOutdoor", 0.0001711705f, -4500.3728183251f, -0.1365493768f);
        addData("TRACK_100H", "femaleOutdoor", 3.9822963262f, -29.9904801411f, 0.1130387851f);
        addData("TRACK_400H", "femaleOutdoor", 0.2085649572f, -129.9952469068f, -0.0011574468f);
        addData("TRACK_2000SC", "femaleOutdoor", 0.0045000012f, -879.9946744771f, 0.0008898666f);
        addData("TRACK_3000SC", "femaleOutdoor", 0.0013229981f, -1509.9954525199f, -0.0000262420f);
        addData("TRACK_4x100", "femaleOutdoor", 0.3895003606f, -97.9948488911f, 0.0029041676f);
        addData("TRACK_4x200", "femaleOutdoor", 0.0794985466f, -211.9961734118f, -0.0049477681f);
        addData("TRACK_4x400", "femaleOutdoor", 0.0156200769f, -479.9939979174f, 0.0031084665f);
        addData("ROAD_10MILES", "femaleOutdoor", 0.0000630001f, -7437.4758774148f, 0.0080292585f);
        addData("ROAD_10KM", "femaleOutdoor", 0.0001742155f, -4499.3728557918f, 0.0189492422f);
        addData("ROAD_15KM", "femaleOutdoor", 0.0000732017f, -6904.4306434582f, 0.0130446762f);
        addData("ROAD_20KM", "femaleOutdoor", 0.0000396007f, -9356.4394963166f, 0.0048254690f);
        addData("ROAD_25KM", "femaleOutdoor", 0.0000228009f, -12143.3511225215f, 0.0103960906f);
        addData("ROAD_30KM", "femaleOutdoor", 0.0000142603f, -15122.3881022298f, 0.0055215143f);
        addData("ROAD_100KM", "femaleOutdoor", 0.0000008740f, -61199.5508531756f, -0.0005792629f);
        addData("ROAD_HALF_MARATHON", "femaleOutdoor", 0.0000352993f, -9899.5699844392f, -0.0079093982f);
        addData("ROAD_MARATHON", "femaleOutdoor", 0.0000059501f, -22799.3431644815f, 0.0052008190f);
        addData("WALK_3KM", "femaleOutdoor", 0.0008815855f, -1870.3738882049f, 0.0003505436f);
        addData("WALK_5KM", "femaleOutdoor", 0.0003247214f, -3139.1595926748f, 0.0774715361f);
        addData("WALK_10KM", "femaleOutdoor", 0.0000779012f, -6436.4586699003f, 0.0060104500f);
        addData("WALK_20KM", "femaleOutdoor", 0.0000186999f, -13199.5111582929f, 0.0001676005f);
        addData("WALK_30KM", "femaleOutdoor", 0.0000068999f, -21544.6466392712f, -0.0051495959f);
        addData("WALK_50KM", "femaleOutdoor", 0.0000019600f, -39951.5338662223f, -0.0002048037f);
        addData("HIGH_JUMP", "femaleOutdoor", 39.5579087445f, 10.5082093421f, -4969.5880642855f);
        addData("LONG_JUMP", "femaleOutdoor", 1.9581140326f, 49.4597044183f, -5024.0505434215f);
        addData("TRIPLE_JUMP", "femaleOutdoor", 0.4296645887f, 105.1320544518f, -4980.6423815636f);
        addData("DISCUS_THROW", "femaleOutdoor", 0.0040284238f, 2226.8877644471f, -19996.2817097077f);
        addData("HAMMER_THROW", "femaleOutdoor", 0.0030967240f, 2539.8077202523f, -19998.4991354651f);
        addData("JAVELIN_THROW", "femaleOutdoor", 0.0040722745f, 2215.2996127575f, -20003.7430818798f);
        addData("POLE_VAULT", "femaleOutdoor", 3.9325797501f, 35.0265857026f, -5029.8531935972f);
        addData("SHOT_PUT", "femaleOutdoor", 0.0462143876f, 657.3172794694f, -19993.5978247992f);
        addData("HEPTATHLON", "femaleOutdoor", 0.0000015806f, 56004.0768596358f, -5001.3485654597f);

        // Men Outdoor
        addData("TRACK_100", "maleOutdoor", 24.6422116633f, -16.9975315583f, -0.2186620480f);
        addData("TRACK_200", "maleOutdoor", 5.0833296257f, -35.4911115974f, 0.0957410215f);
        addData("TRACK_300", "maleOutdoor", 1.8296570247f, -57.1976881434f, -0.0553585925f);
        addData("TRACK_400", "maleOutdoor", 1.0210130426f, -78.9946930564f, 0.0029880052f);
        addData("TRACK_600", "maleOutdoor", 0.3669867740f, -130.9961594799f, -0.0103075994f);
        addData("TRACK_800", "maleOutdoor", 0.1980049254f, -181.9938575678f, 0.0091543669f);
        addData("TRACK_1000", "maleOutdoor", 0.1074010815f, -239.9941856026f, 0.0042507048f);
        addData("TRACK_1500", "maleOutdoor", 0.0406599253f, -384.9950051367f, 0.0012055910f);
        addData("TRACK_1MILE", "maleOutdoor", 0.0350996776f, -414.9960661793f, -0.0028258109f);
        addData("TRACK_2000", "maleOutdoor", 0.0218100318f, -527.9948241122f, 0.0001703359f);
        addData("TRACK_3000", "maleOutdoor", 0.0081500499f, -839.9938439226f, 0.0015204438f);
        addData("TRACK_2MILES", "maleOutdoor", 0.0070299885f, -904.7954323334f, -0.0009453377f);
        addData("TRACK_5000", "maleOutdoor", 0.0027779979f, -1439.9953256617f, -0.0004296371f);
        addData("TRACK_10000", "maleOutdoor", 0.0005239994f, -3149.9962170853f, -0.0004979093f);
        addData("TRACK_110H", "maleOutdoor", 7.6652061276f, -25.7930225928f, 0.0141087786f);
        addData("TRACK_400H", "maleOutdoor", 0.5459888468f, -95.4953371509f, 0.0002166679f);
        addData("TRACK_2000SC", "maleOutdoor", 0.0102299858f, -659.9952837440f, -0.0004264088f);
        addData("TRACK_3000SC", "maleOutdoor", 0.0043159973f, -1019.9952251094f, -0.0005178463f);
        addData("TRACK_4x100", "maleOutdoor", 1.2360320754f, -69.4946755547f, 0.0020228151f);
        addData("TRACK_4x200", "maleOutdoor", 0.2976775548f, -143.9939035213f, 0.0118168894f);
        addData("TRACK_4x400", "maleOutdoor", 0.0502588314f, -333.9973041754f, -0.0080115351f);
        addData("ROAD_10MILES", "maleOutdoor", 0.0001852499f, -5249.1013647510f, 0.1014745309f);
        addData("ROAD_10KM", "maleOutdoor", 0.0005287550f, -3149.1524016199f, 0.0690327319f);
        addData("ROAD_15KM", "maleOutdoor", 0.0002161981f, -4867.5076944338f, -0.0026187446f);
        addData("ROAD_20KM", "maleOutdoor", 0.0001147009f, -6628.4786813353f, 0.0058310275f);
        addData("ROAD_25KM", "maleOutdoor", 0.0000676515f, -8535.4393562416f, 0.0146077104f);
        addData("ROAD_30KM", "maleOutdoor", 0.0000435300f, -10530.5042235755f, -0.0010360804f);
        addData("ROAD_100KM", "maleOutdoor", 0.0000017650f, -48599.6069691841f, -0.0015614538f);
        addData("ROAD_HALF_MARATHON", "maleOutdoor", 0.0001020050f, -7019.4133397892f, 0.0119952047f);
        addData("ROAD_MARATHON", "maleOutdoor", 0.0000191003f, -15599.4039272134f, 0.0084789663f);
        addData("WALK_3KM", "maleOutdoor", 0.0012098241f, -1649.4765816626f, -0.0505185382f);
        addData("WALK_5KM", "maleOutdoor", 0.0004362569f, -2759.0822412767f, 0.1020221477f);
        addData("WALK_10KM", "maleOutdoor", 0.0001117981f, -5579.5315898026f, -0.0080979259f);
        addData("WALK_20KM", "maleOutdoor", 0.0000273504f, -11399.4559313645f, 0.0012286251f);
        addData("WALK_30KM", "maleOutdoor", 0.0000089299f, -19109.6015775776f, -0.0054860378f);
        addData("WALK_35KM", "maleOutdoor", 0.0000057601f, -23399.3873516061f, 0.0029317504f);
        addData("WALK_50KM", "maleOutdoor", 0.0000021240f, -37199.5521047347f, -0.0008918298f);
        addData("HIGH_JUMP", "maleOutdoor", 32.1457081634f, 11.5936889433f, -5026.0808417004f);
        addData("LONG_JUMP", "maleOutdoor", 1.9310928730f, 48.3486190515f, -4993.8077931235f);
        addData("TRIPLE_JUMP", "maleOutdoor", 0.4603666024f, 98.8014630138f, -5008.9686647032f);
        addData("DISCUS_THROW", "maleOutdoor", 0.0040063129f, 2232.9834114813f, -20003.5249226571f);
        addData("HAMMER_THROW", "maleOutdoor", 0.0028034429f, 2669.7566381795f, -20002.8716570753f);
        addData("JAVELIN_THROW", "maleOutdoor", 0.0024031525f, 2879.7978639657f, -19950.9683606244f);
        addData("POLE_VAULT", "maleOutdoor", 3.0457199209f, 39.3358603090f, -4993.2138282251f);
        addData("SHOT_PUT", "maleOutdoor", 0.0423461436f, 684.8281542324f, -19915.7245727669f);
        addData("DECATHLON", "maleOutdoor", 0.0000009772f, 71186.6785041732f, -5001.0472144005f);

    }

    private static void addData(String event, String category, float a, float b, float c) {
        boolean isField = true;

        if (event.contains("TRACK") || event.contains("ROAD") || event.contains("WALK")) {
            isField = false;
        }

        event = category + event;
        event = event.replace("TRACK_", "");
        constantsHashMap.put(event, new Constants(a, b, c, isField));
    }

    //each event combo is stored in the HashMap
    private static class Constants {
        Boolean isField;
        Function<Float, Float> getScoreFunc;
        Function<Float, Float> getPerformanceFunc;


        Constants(float a, float b, float c, Boolean isField) {
            this.isField = isField;

            //score function
            getScoreFunc = (x) -> a * (float) Math.pow((x + b), 2) + c;

            //performanceFunc (ie inverse of score) for field events
            if(isField){
                getPerformanceFunc = (x) -> (1 * (float) Math.sqrt(a * (x - c)) / a - b);
            }
            else{             //performanceFunc (ie inverse of score) for running events
                getPerformanceFunc = (x) -> (-1 * (float) Math.sqrt(a * (x - c)) / a - b);
            }
        }


    }

}
//track road and walk have times everything else isField