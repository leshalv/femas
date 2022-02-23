/**
 * Tencent is pleased to support the open source community by making Polaris available.
 * <p>
 * Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
 * <p>
 * Licensed under the BSD 3-Clause License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://opensource.org/licenses/BSD-3-Clause
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.tencent.tsf.femas.governance.config.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tencent.tsf.femas.governance.circuitbreaker.rule.CircuitBreakerRule;
import com.tencent.tsf.femas.governance.plugin.config.PluginConfigImpl;
import com.tencent.tsf.femas.governance.plugin.config.gov.CircuitBreakerConfig;
import com.tencent.tsf.femas.governance.plugin.config.verify.DefaultValues;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

/**
 * 熔断相关的配置项
 *
 * @author andrewshan
 * @date 2019/8/20
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CircuitBreakerConfigImpl extends PluginConfigImpl implements CircuitBreakerConfig {

    @JsonProperty
    private Boolean enable;

    @JsonProperty
    private List<String> chain;

    @JsonProperty
    private List<CircuitBreakerRule> circuitBreakerRule;

    @Override
    public boolean isEnable() {
        if (null == enable) {
            return DefaultValues.DEFAULT_CIRCUIT_BREAKER_ENABLE;
        }
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<CircuitBreakerRule> getCircuitBreakerRule() {
        return circuitBreakerRule;
    }

    public void setCircuitBreakerRule(List<CircuitBreakerRule> circuitBreakerRule) {
        this.circuitBreakerRule = circuitBreakerRule;
    }

    @Override
    public List<String> getChain() {
        return chain;
    }

    public void setChain(List<String> chain) {
        this.chain = chain;
    }

    @Override
    public void verify() throws IllegalArgumentException {

    }

    @Override
    public void setDefault() {
        if (CollectionUtils.isEmpty(chain) || enable == null) {
            enable = DefaultValues.DEFAULT_CIRCUIT_BREAKER_ENABLE;
            chain = new ArrayList<>();
            chain.add(DefaultValues.DEFAULT_CIRCUIT_BREAKER);
        }
    }

    @Override
    public String toString() {
        return "CircuitBreakerConfigImpl{" +
                "enable=" + enable +
                ", chain=" + chain +
                '}';
    }
}
