/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2015 ForgeRock AS.
 */

package com.sun.identity.rest;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.forgerock.guice.core.GuiceModule;

/**
 * Guice module for binding the legacy REST API endpoints.
 *
 * @since 13.0.0
 */
@GuiceModule
public class LegacyRestGuiceModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<LegacyRestEndpoint> endpointMultibinder =
                Multibinder.newSetBinder(binder(), LegacyRestEndpoint.class);
        endpointMultibinder.addBinding()
                .toInstance(new LegacyRestEndpoint(CoreTokenResource.class));
        endpointMultibinder.addBinding()
                .toInstance(new LegacyRestEndpoint(ListenerResource.class));
    }
}
