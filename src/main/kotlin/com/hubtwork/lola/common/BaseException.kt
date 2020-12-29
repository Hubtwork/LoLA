package com.hubtwork.lola.common

open class BaseException: RuntimeException
{
    constructor(msg: String?): super(msg)
    constructor(msg: String?, source: Throwable?): super(msg, source)
}