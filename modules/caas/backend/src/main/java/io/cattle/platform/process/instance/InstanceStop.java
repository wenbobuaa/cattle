package io.cattle.platform.process.instance;

import io.cattle.platform.agent.AgentLocator;
import io.cattle.platform.core.constants.InstanceConstants;
import io.cattle.platform.eventing.EventService;
import io.cattle.platform.metadata.MetadataManager;
import io.cattle.platform.object.ObjectManager;
import io.cattle.platform.object.process.ObjectProcessManager;
import io.cattle.platform.object.serialization.ObjectSerializer;

import java.util.Arrays;

public class InstanceStop extends DeploymentSyncRequestHandler {

    public InstanceStop(AgentLocator agentLocator, ObjectSerializer serializer, ObjectManager objectManager, ObjectProcessManager processManager, DeploymentSyncFactory syncFactory, MetadataManager metadataManager, EventService eventService) {
        super(agentLocator, serializer, objectManager, processManager, syncFactory, metadataManager, eventService);
        shortCircuitIfAgentRemoved = true;
        commandName = "compute.instance.deactivate";
        processDataKeys = Arrays.asList("timeout",
                InstanceConstants.PROCESS_DATA_NO_OP);
    }

}
