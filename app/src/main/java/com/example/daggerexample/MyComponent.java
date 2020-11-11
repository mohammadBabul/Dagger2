package com.example.daggerexample;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ShareModule.class})
public interface MyComponent {
    public void inject(MainActivity activity);
}
