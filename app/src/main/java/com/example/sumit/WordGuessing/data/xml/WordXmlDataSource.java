package com.example.sumit.WordGuessing.data.xml;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.sumit.WordGuessing.data.WordDataSource;
import com.example.sumit.WordGuessing.model.Word;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.xml.parsers.SAXParserFactory;

public class WordXmlDataSource implements WordDataSource {

    private static final String ASSET_WORD_BANK_FILE = "words.xml";

    private AssetManager mAssetManager;

    @Inject
    public WordXmlDataSource(Context context) {
        mAssetManager = context.getAssets();
    }

    @Override
    public List<Word> getWords() {
        try {
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            WordBankHandler wordBankHandler = new WordBankHandler();
            reader.setContentHandler(wordBankHandler);
            reader.parse(getXmlInputSource());

            return wordBankHandler.getWords();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private InputSource getXmlInputSource() throws IOException {
        return new InputSource(mAssetManager.open(ASSET_WORD_BANK_FILE));
    }
}
