package com.hanifiamdev.validation;

import com.hanifiamdev.validation.container.Data;
import com.hanifiamdev.validation.container.DataInteger;
import com.hanifiamdev.validation.container.Entry;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest {

    @Test
    void testSampleData() {

        SampleData data = new SampleData();
        data.setData(new Data<>());
        data.getData().setData(" ");

        validate(data);
    }

    @Test
    void testSampleEntry() {

        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());
        sampleEntry.getEntry().setKey("");

        validate(sampleEntry);
    }

    @Test
    void testSampleDataInteger() {

        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setData(new DataInteger());
        sampleDataInteger.getData().setData(0);

        validate(sampleDataInteger);
    }
}
