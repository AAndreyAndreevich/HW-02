package comparatorUniversities;

import org.apache.commons.lang3.StringUtils;
import model.University;

public class SortById implements UniversityComparator {
    @Override
    public int compare(University un1, University un2) {
        return StringUtils.compare(un1.getId(), un2.getId());
    }
}