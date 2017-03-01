(set-env!
 :resource-paths #{"src"}
 :dependencies '[[org.jgroups/jgroups "4.0.0.Final"]])

(task-options!
 pom {:project 'clj-groups
      :version "0.1.0-SNAPSHOT"}
 jar {:manifest {"a" "b"}})
