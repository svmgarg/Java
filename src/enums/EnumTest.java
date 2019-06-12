package enums;

import java.util.HashMap;
import java.util.Map;

public class EnumTest {
    public static void main(String args[]) {

        System.out.println(CiTypeEnum.valueOf(RoutineTypeEnum.SCHEDULED.value));
    }

    enum RoutineTypeEnum {

        SCHEDULED("SCHEDULED1"), WHEN_YOU_SAY("WHEN_YOU_SAY"), CONDITIONAL("CONDITIONAL"), PLAY_ROUTINE("PLAY_ROUTINE");

        private String value;

        private RoutineTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }


    enum CiTypeEnum {
        RT("ROUTINE"),
        SCH_RT("SCHEDULED1"),
        COND_RT("CONDITIONAL"),
        PRT("PLAY_ROUTINE"),
        NRT("NON_ROUTINE");

        private static final Map<String, CiTypeEnum> EnumMap = new HashMap<>();

        static {
            for (CiTypeEnum ciTypeEnum : values()) {
                EnumMap.put(ciTypeEnum.name(), ciTypeEnum);
            }
        }

        public static CiTypeEnum getByName(String name) {
            return EnumMap.get(name);
        }


        private String value;

        private CiTypeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }


    }


}
