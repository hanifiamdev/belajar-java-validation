package com.hanifiamdev.validation.extractor;

import com.hanifiamdev.validation.container.DataInteger;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;

@UnwrapByDefault
public class DataIntegerValueExtractor implements ValueExtractor<@ExtractedValue(type = Integer.class) DataInteger> {

    @Override
    public void extractValues(@ExtractedValue(type = Integer.class) DataInteger originalValue, ValueReceiver receiver) {
        receiver.value(null, originalValue.getData());
    }
}
