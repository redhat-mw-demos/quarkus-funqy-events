package org.acme;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(includeClasses = {Input.class}, schemaPackageName = "input_sample")
interface InputContextInitializer extends SerializationContextInitializer {
}
