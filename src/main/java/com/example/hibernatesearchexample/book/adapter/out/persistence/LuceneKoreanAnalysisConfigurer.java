package com.example.hibernatesearchexample.book.adapter.out.persistence;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.ko.KoreanPartOfSpeechStopFilterFactory;
import org.apache.lucene.analysis.ko.KoreanTokenizer;
import org.apache.lucene.analysis.ko.KoreanTokenizerFactory;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;
import org.springframework.stereotype.Component;

@Component
class LuceneKoreanAnalysisConfigurer implements LuceneAnalysisConfigurer {

    @Override
    public void configure(LuceneAnalysisConfigurationContext context) {
        context.analyzer("korean").custom()
                .tokenizer(KoreanTokenizerFactory.class)
                .param("decompoundMode", KoreanTokenizer.DecompoundMode.MIXED.toString())
                .tokenFilter(LowerCaseFilterFactory.class)
                .tokenFilter(KoreanPartOfSpeechStopFilterFactory.class);
    }
}
