// Built in constant --------------------------------------------------------------------
const int gl_MaxVertexAttribs = 16;
const int gl_MaxVertexUniformVectors = 256;
const int gl_MaxVertexUniformComponents = 1024;
const int gl_MaxVertexOutputComponents = 64;
const int gl_MaxVaryingComponents = 60;
const int gl_MaxVaryingVectors = 15;
const int gl_MaxVertexTextureImageUnits = 16;
const int gl_MaxVertexImageUniforms = 0;
const int gl_MaxVertexAtomicCounters = 0;
const int gl_MaxVertexAtomicCounterBuffers = 0;

const int gl_MaxTessPatchComponents = 120;
const int gl_MaxPatchVertices = 32;
const int gl_MaxTessGenLevel = 64;

const int gl_MaxTessControlInputComponents = 128;
const int gl_MaxTessControlOutputComponents = 128;
const int gl_MaxTessControlTextureImageUnits = 16;
const int gl_MaxTessControlUniformComponents = 1024;
const int gl_MaxTessControlTotalOutputComponents = 4096;
const int gl_MaxTessControlImageUniforms = 0;
const int gl_MaxTessControlAtomicCounters = 0;
const int gl_MaxTessControlAtomicCounterBuffers = 0;

const int gl_MaxTessEvaluationInputComponents = 128;
const int gl_MaxTessEvaluationOutputComponents = 128;
const int gl_MaxTessEvaluationTextureImageUnits = 16;
const int gl_MaxTessEvaluationUniformComponents = 1024;
const int gl_MaxTessEvaluationImageUniforms = 0;
const int gl_MaxTessEvaluationAtomicCounters = 0;
const int gl_MaxTessEvaluationAtomicCounterBuffers = 0;

const int gl_MaxGeometryInputComponents = 64;
const int gl_MaxGeometryOutputComponents = 128;
const int gl_MaxGeometryImageUniforms = 0;
const int gl_MaxGeometryTextureImageUnits = 16;
const int gl_MaxGeometryOutputVertices = 256;
const int gl_MaxGeometryTotalOutputComponents = 1024;
const int gl_MaxGeometryUniformComponents = 1024;
const int gl_MaxGeometryVaryingComponents = 64;            // deprecated
const int gl_MaxGeometryAtomicCounters = 0;
const int gl_MaxGeometryAtomicCounterBuffers = 0;

const int gl_MaxFragmentImageUniforms = 8;
const int gl_MaxFragmentInputComponents = 128;
const int gl_MaxFragmentUniformVectors = 256;
const int gl_MaxFragmentUniformComponents = 1024;
const int gl_MaxFragmentAtomicCounters = 8;
const int gl_MaxFragmentAtomicCounterBuffers = 1;

const int gl_MaxDrawBuffers = 8;
const int gl_MaxTextureImageUnits = 16;
const int gl_MinProgramTexelOffset = -8;
const int gl_MaxProgramTexelOffset = 7;
const int gl_MaxImageUnits = 8;
const int gl_MaxSamples = 4;
const int gl_MaxImageSamples = 0;
const int gl_MaxClipDistances = 8;
const int gl_MaxCullDistances = 8;
const int gl_MaxViewports = 16;

const int gl_MaxComputeImageUniforms = 8;
// const ivec3 gl_MaxComputeWorkGroupCount = { 65535, 65535, 65535 };
// const ivec3 gl_MaxComputeWorkGroupSize = { 1024, 1024, 64 };
const int gl_MaxComputeUniformComponents = 1024;
const int gl_MaxComputeTextureImageUnits = 16;
const int gl_MaxComputeAtomicCounters = 8;
const int gl_MaxComputeAtomicCounterBuffers = 8;

const int gl_MaxCombinedTextureImageUnits = 96;
const int gl_MaxCombinedImageUniforms = 48;
const int gl_MaxCombinedImageUnitsAndFragmentOutputs = 8;  // deprecated
const int gl_MaxCombinedShaderOutputResources = 16;
const int gl_MaxCombinedAtomicCounters = 8;
const int gl_MaxCombinedAtomicCounterBuffers = 1;
const int gl_MaxCombinedClipAndCullDistances = 8;
const int gl_MaxAtomicCounterBindings = 1;
const int gl_MaxAtomicCounterBufferSize = 32;

const int gl_MaxTransformFeedbackBuffers = 4;
const int gl_MaxTransformFeedbackInterleavedComponents = 64;

// const highp int gl_MaxInputAttachments = 1;  // only present when targeting Vulkan

// TODO: vec support, initializer support

// Built in language variable -----------------------------------------------------------------
in int gl_VertexID;       // only present when not targeting Vulkan
in int gl_InstanceID;     // only present when not targeting Vulkan
in int gl_VertexIndex;    // only present when targeting Vulkan
in int gl_InstanceIndex;  // only present when targeting Vulkan
in int gl_DrawID;
in int gl_BaseVertex;
in int gl_BaseInstance;
