package aop_annotation.pokedex;

import aop_annotation.pokedex.business.domain.Pokemon;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyFirstAspect {
    @Before("execution(* findPokemon(int))")
    public void before() {
        // 메서드 시작 시 동작하는 어드바이스
        System.out.println("Before");
    }

    @After("execution(* findPokemon(int))")
    public void after() {
        // 메서드 종료 후 동작하는 어드바이스
        System.out.println("After");
    }

    @AfterReturning(value = "execution(* findPokemon(int))", returning = "pokemon")
    public void afterReturning(Pokemon pokemon) {
        // 메서드가 예외 없이 종료했을 때 동작하는 어드바이스
        System.out.println(pokemon.getName());
    }

    @Around("execution(* findPokemon(int))")
    public Pokemon around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 메서드 호출 전 후에 동작하는 어드바이스
        System.out.println("Around before");
        Pokemon pokemon = (Pokemon)proceedingJoinPoint.proceed();
        System.out.println("Around after");

        return pokemon;
    }

    @AfterThrowing(value = "execution(* findPokemon(int))", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        // 메서드 호출이 에외를 던졌을 때 동작하는 어드바이스. 위 around에서 return null로 하면 이 어드바이스가 동작한다
        System.out.println("Throwing");
    }
}
