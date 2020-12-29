package com.hubtwork.lola.datapipeline

import com.fasterxml.jackson.databind.JsonNode

class DataDragon {

    protected class Reuquest {
        lateinit var file: String
        lateinit var version: String
        lateinit var location: String


    }

    class InternalDataProcessor(data: Set<String>) {

        private final var ITEM_TAGS = setOf<String>("id", "name", "description", "plaintext", )


    }

}