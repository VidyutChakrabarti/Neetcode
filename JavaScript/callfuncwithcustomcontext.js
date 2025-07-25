Function.prototype.callPolyfill = function (context, ...args) {
    const fn = this;

    Object.defineProperty(context, '__fn__', {
        value: fn,
        enumerable: false
    });

    const result = context.__fn__(...args);

    delete context.__fn__;

    return typeof result !== 'undefined' ? result : undefined;
};