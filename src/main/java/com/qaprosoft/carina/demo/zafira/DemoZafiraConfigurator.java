package com.qaprosoft.carina.demo.zafira;

import com.qaprosoft.carina.core.foundation.commons.SpecialKeywords;
import com.qaprosoft.carina.core.foundation.report.ZafiraConfigurator;
import com.qaprosoft.carina.core.foundation.utils.tag.PriorityManager;
import com.qaprosoft.carina.core.foundation.utils.tag.TagManager;
import com.qaprosoft.carina.demo.zafira.tag.DemoFeatureManager;
import com.qaprosoft.zafira.models.dto.TagType;
import org.testng.ITestResult;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DemoZafiraConfigurator extends ZafiraConfigurator {

    private static final String IGNORED_FEATURE = "UNKNOWN";

    @Override
    public Set<TagType> getTestTags(ITestResult test) {
        LOGGER.debug("Collecting TestTags");
        Set<TagType> tags = new HashSet();

        String testPriority = PriorityManager.getPriority(test);
        if (testPriority != null && !testPriority.isEmpty()) {
            TagType priority = new TagType();
            priority.setName(SpecialKeywords.TEST_PRIORITY_KEY);
            priority.setValue(testPriority);
            tags.add(priority);
        }

        String testFeature = DemoFeatureManager.getFeature(test);
        if (testFeature != null && !testFeature.isEmpty() && !testFeature.equalsIgnoreCase(IGNORED_FEATURE)) {
            TagType feature = new TagType();
            feature.setName(SpecialKeywords.TEST_FEATURE_KEY);
            feature.setValue(testFeature);
            tags.add(feature);
        }

        Map<String, String> testTags = TagManager.getTags(test);

        testTags.entrySet().stream().forEach((entry) -> {
            TagType tagEntry = new TagType();
            tagEntry.setName(entry.getKey());
            tagEntry.setValue(entry.getValue());
            tags.add(tagEntry);
        });

        LOGGER.info("Found " + tags.size() + " new TestTags");
        return tags;
    }
}
